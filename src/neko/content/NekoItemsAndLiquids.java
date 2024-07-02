package neko.content;

import mindustry.type.Item;
import mindustry.type.Liquid;

public class NekoItemsAndLiquids {

    public static Item cophalast, trinaxide, monoglox, polamenis,
            xenathium, hilimeni, hexademia, kructrok, nasmehro, flukemasd;
    public static Liquid medrali, poligen, petragen;

    public static void load() {
        // item
        cophalast = new Item("Cophalast") {
            {
                localizedName = "Cophalast";
                cost = 1f;
            }
        };

        trinaxide = new Item("Trinaxide") {
            {
                localizedName = "Trinaxide";
                cost = 1f;
            }
        };

        monoglox = new Item("Monoglox") {
            {
                localizedName = "Monoglox";
                cost = 1f;
            }
        };

        polamenis = new Item("Polanemis") {
            {
                localizedName = "Polanemis";
                cost = 1f;
                flammability = 1f;
                explosiveness = 0.2f;
            }
        };

        xenathium = new Item("Xenathium") {
            {
                localizedName = "Xenathium";
                cost = 1f;
            }
        };

        hilimeni = new Item("Hilimeni") {
            {
                localizedName = "Hilimeni";
                cost = 1f;
                flammability = 0.2f;
                explosiveness = 1f;
            }
        };

        hexademia = new Item("Hexademia") {
            {
                localizedName = "Hexademia";
                cost = 1f;
            }
        };

        // Synthetic materials

        kructrok = new Item("Kructrok") {
            {
                localizedName = "Kructrok";
                cost = 1f;
            }
        };

        nasmehro = new Item("Nasmehro") {
            {
                localizedName = "Nasmehro";
                cost = 1f;
            }
        };

        flukemasd = new Item("Flukemasd") {
            {
                localizedName = "Flukemasd fiber";
                cost = 1f;
            }
        };

        // liquid
        medrali = new Liquid("Medrali") {
            {
                localizedName = "Medrali";
                coolant = true;
                heatCapacity = 1f;
            }
        };

        poligen = new Liquid("Poligen") {
            {
                localizedName = "Poligen";
                coolant = true;
                heatCapacity = 1.6f;
                gas = true;
            }
        };

        petragen = new Liquid("Petragen") {
            {
                localizedName = "Petragen";
                coolant = false;
                gas = true;
            }
        };
    }
}
