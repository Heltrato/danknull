package com.inteloperator.danknull.api;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.awt.*;

/**
 * @author p455w0rd
 */
public class DankNullItemModes {

    public enum ItemExtractionMode {

        KEEP_ALL(Integer.MAX_VALUE, Component.translatable("dn.not_extract.desc").toString()),
        KEEP_1(1, Component.translatable("dn.extract_all_but.desc" + " 1").toString()),
        KEEP_16(16, "dn.extract_all_but.desc"+ " 16"),
        KEEP_64(64, "dn.extract_all_but.desc"+ " 64"),
        KEEP_NONE(0, "dn.extract_all.desc");

        public static ItemExtractionMode[] VALUES = values();
        int number = 0;
        String msg;

        ItemExtractionMode(final int numberToKeep, final String message) {
            number = numberToKeep;
            msg = message;
        }

        public int getNumberToKeep() {
            return number;
        }

        public String getMessage() {
            return "dn.will.desc" + " " + msg + " " +"dn.from_slot.desc";
        }

        public String getTooltip() {
            if (toString().equals("KEEP_ALL")) {
                return "dn.do.desc" + " " + msg;
            }
            return msg.substring(0, 1).toUpperCase() + msg.substring(1);
        }

    }

    public enum ItemPlacementMode {

        KEEP_ALL(Integer.MAX_VALUE,"dn.not_place.desc"),
        KEEP_1(1,"dn.place_all_but.desc" + " 1"),
        KEEP_16(16, "dn.place_all_but.desc" + " 16"),
        KEEP_64(64, "dn.place_all_but.desc"+ " 64"),
        KEEP_NONE(0, "dn.place_all.desc");

        public static ItemPlacementMode[] VALUES = values();
        int number = 0;
        String msg;

        ItemPlacementMode(final int numberToKeep, final String message) {
            number = numberToKeep;
            msg = message;
        }

        public int getNumberToKeep() {
            return number;
        }

        public String getMessage() {
            return "dn.will.desc" + " " + msg + " " + "dn.from_slot.desc";
        }

        public String getTooltip() {
            if (toString().equals("KEEP_ALL")) {
                return"dn.do.desc"+ " " + msg;
            }
            return msg.substring(0, 1).toUpperCase() + msg.substring(1);
        }

    }

}