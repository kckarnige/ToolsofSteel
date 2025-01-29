package com.kckarnige.toolsofsteel.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class MidnightConfigStuff extends MidnightConfig {
    public static final String CONFIG = "CONFIG";

    @Entry(category = CONFIG) public static boolean REMOVE_RPS = false;
    @Entry(category = CONFIG) public static boolean REMOVE_REPAIR_CHANGES = false;
    @Entry(category = CONFIG) public static boolean REMOVE_DURABILITY_CHANGES = false;
}
