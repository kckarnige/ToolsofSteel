package com.kckarnige.toolsofsteel.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class MidnightConfigStuff extends MidnightConfig {
    public static final String clientCONFIG = "client";
    public static final String serverCONFIG = "server";

    @Entry(category = clientCONFIG) public static boolean remove_tweaks_rp = false;
    @Entry(category = clientCONFIG) public static boolean remove_knows_rp = false;


    @Entry(category = serverCONFIG) public static boolean remove_repair_changes = false;
    @Entry(category = serverCONFIG) public static boolean remove_durability_changes = false;
    @Entry(category = serverCONFIG) public static boolean remove_loot_table_changes = false;

    @Comment(category = serverCONFIG) public static Comment danger_spacer;

    @Comment(category = serverCONFIG, centered = true) public static Comment danger_zone;
    @Entry(category = serverCONFIG) public static boolean bypass_crash = false;
}
