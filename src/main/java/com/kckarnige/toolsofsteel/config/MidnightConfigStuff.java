package com.kckarnige.toolsofsteel.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class MidnightConfigStuff extends MidnightConfig {
    public static final String clientCONFIG = "client";
    public static final String serverCONFIG = "server";
    public static final String advancedCONFIG = "advanced";

    @Entry(category = clientCONFIG) public static boolean remove_tweaks_rp = false;
    @Entry(category = clientCONFIG) public static boolean remove_knows_rp = false;


    @Entry(category = serverCONFIG) public static boolean vanilla_steel_recipes = false;
    @Entry(category = serverCONFIG) public static boolean revert_diamond_recipes = false;
    @Entry(category = serverCONFIG) public static boolean remove_repair_changes = false;
    @Entry(category = serverCONFIG) public static boolean remove_durability_changes = false;
    @Entry(category = serverCONFIG) public static boolean remove_loot_table_changes = false;

    @Entry(category = advancedCONFIG) public static boolean bypass_crash = false;
}
