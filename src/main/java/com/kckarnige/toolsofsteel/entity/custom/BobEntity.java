package com.kckarnige.toolsofsteel.entity.custom;

import com.kckarnige.toolsofsteel.entity.ai.BobAttackGoal;
import com.kckarnige.toolsofsteel.items.ItemRegister;
import com.seacroak.bronze.registry.MainRegistry;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;


public class BobEntity extends SkeletonEntity {
    private final ServerBossBar bossBar;
    protected final SwimNavigation waterNavigation;
    private static final TrackedData<Boolean> attacking = DataTracker.registerData(BobEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private boolean spawnedBackup = false;

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public int attackAnimationTimeout = 0;

    public BobEntity(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = (ServerBossBar)(new ServerBossBar(this.getDisplayName(), BossBar.Color.PURPLE, BossBar.Style.PROGRESS)).setDarkenSky(true);
        this.waterNavigation = new SwimNavigation(this, world);
        this.setHealth(this.getMaxHealth());
        this.experiencePoints = 50;
    }


    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new BobAttackGoal(this, 1d, true));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, TurtleEntity.class, 10, true, false, TurtleEntity.BABY_TURTLE_ON_LAND_FILTER));
    }

    public void setAttacking (boolean val) {
        this.dataTracker.set(attacking, val);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(attacking);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(attacking, false);
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean bl = super.tryAttack(target);
        if (bl) {
            float f = this.getWorld().getLocalDifficulty(this.getBlockPos()).getLocalDifficulty();
            if (this.getMainHandStack().isEmpty() && this.isOnFire() && this.random.nextFloat() < f * 0.3F) {
                target.setOnFireFor((float)(2 * (int)f));
            }
        }
        return bl;
    }

    @Override
    protected void mobTick() {
        super.mobTick();
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
        if (this.spawnedBackup) {
            if (this.getHealth() <= this.getMaxHealth()/2) {
                this.spawnedBackup = true;
                this.getWorld().spawnEntity(new SkeletonEntity(EntityType.SKELETON, this.getEntityWorld()));
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_HUSK_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_HUSK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_HUSK_DEATH;
    }

    SoundEvent getStepSound() {
        return SoundEvents.ENTITY_SKELETON_STEP;
    }

    @Override
    protected boolean isAffectedByDaylight() {
        return false;
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (this.hasCustomName()) {
            this.bossBar.setName(this.getDisplayName());
        }
    }

    @Override
    public void checkDespawn() {
        if (this.getWorld().getDifficulty() == Difficulty.PEACEFUL && this.isDisallowedInPeaceful()) {
            this.discard();
        } else {
            this.despawnCounter = 0;
        }
    }

    @Override
    public void setCustomName(@Nullable Text name) {
        super.setCustomName(name);
        this.bossBar.setName(this.getDisplayName());
    }

    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    @Override
    public boolean canUsePortals(boolean allowVehicles) {
        return false;
    }

    @Override
    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {
        super.initEquipment(random, localDifficulty);
        this.equipStack(EquipmentSlot.HEAD, new ItemStack(ItemRegister.STEEL_HELMET));
        this.equipStack(EquipmentSlot.CHEST, new ItemStack(MainRegistry.BRONZE_CHESTPLATE));
        this.equipStack(EquipmentSlot.FEET, new ItemStack(ItemRegister.STEEL_BOOTS));
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ItemRegister.BATTLE_AXE));
        this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(MainRegistry.SICKLE));
    }

    @Override
    protected void dropEquipment(ServerWorld world, DamageSource source, boolean causedByPlayer) {
        super.dropEquipment(world, source, causedByPlayer);
    }

    @Override
    public boolean canSpawn(WorldView world) {
        return false;
    }

    public static DefaultAttributeContainer.Builder createBobttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 55.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2F)
                .add(EntityAttributes.GENERIC_JUMP_STRENGTH, 0.5F)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.5F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0);
    }

    private void setupAnims() {
        if (this.getWorld().isClient()) {
            if (this.idleAnimationTimeout <= 0) {
                this.idleAnimationTimeout = 63;
                this.idleAnimationState.start(this.age);
            } else {
                --this.idleAnimationTimeout;
            }
            if (this.isAttacking() && attackAnimationTimeout <= 0) {
                this.attackAnimationTimeout = 12;
                this.attackAnimationState.start(this.age);
            } else {
                --this.attackAnimationTimeout;
            }
            if (!this.isAttacking()) {
                attackAnimationState.stop();
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        setupAnims();
    }
}
