package com.kckarnige.toolsofsteel.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class MidnightConfigStuff extends MidnightConfig {
    public static final String CONFIG = "CONFIG";

    @Entry(category = CONFIG) public static boolean REMOVE_RPS = false;
    @Entry(category = CONFIG) public static boolean REMOVE_CHANGES = false;
}
