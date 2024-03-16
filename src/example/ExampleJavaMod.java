package example;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import mindustry.mod.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class ExampleJavaMod extends Mod{

    public static Item cophalast, trinaxide, monoglox, polamenis, xenathium, hilimeni, hexademia, kructrok, nasmehro, flukemasd;
    public static Liquid medrali, poligen, petragen;
    public static Block cophalastDrill, trinaxideBeam, xenathiumDrill, hilimeniLaserBeam, hexademiaDrill, medraliDrill;
    public static Block factorys;

    public ExampleJavaMod(){
    }

    @Override
    public void loadContent(){
        Log.info("Start working for content");
        // loading content. We content too less to in many files      
        // item category:
        
        cophalast = new Item("Cophalast", Color.valueOf("dee650")){{
            localizedName = "Cophalast";
            cost = 1f;
        }};

        trinaxide = new Item("Trinaxide", Color.valueOf("dee650")){{
            localizedName = "Trinaxide";
            cost = 1f;
        }};

        monoglox = new Item("Monoglox", Color.valueOf("dee650")){{
            localizedName = "Monoglox";
            cost = 1f;
        }};

        polamenis = new Item("Polanemis", Color.valueOf("dee650")){{
            localizedName = "Polanemis";
            cost = 1f;
            flammability = 1f;
            explosiveness = 0.2f;
        }};

        xenathium = new Item("Xenathium", Color.valueOf("dee650")){{
            localizedName = "Xenathium";
            cost = 1f;
        }};

        hilimeni = new Item("Hilimeni", Color.valueOf("dee650")){{
            localizedName = "Hilimeni";
            cost = 1f;
            flammability = 0.2f;
            explosiveness = 1f;
        }};

        hexademia = new Item("Hexademia", Color.valueOf("dee650")){{
            localizedName = "Hexademia";
            cost = 1f;
        }};

        // Synthetic materials

        kructrok = new Item("Kructrok", Color.valueOf("dee650")){{
            localizedName = "Kructrok";
            cost = 1f;
        }};

        nasmehro = new Item("Nasmehro", Color.valueOf("dee650")){{
            localizedName = "Nasmehro";
            cost = 1f;
        }};

        flukemasd = new Item("Flukemasd", Color.valueOf("dee650")){{
            localizedName = "Flukemasd fiber";
            cost = 1f;
        }};

        // End of material, start for liquid.
        
        medrali = new Liquid("Medrali", Color.valueOf("ffee00")){{
            localizedName = "Medrali";
            coolant = true; heatCapacity = 1f;
        }};

        poligen = new Liquid("Poligen", Color.valueOf("ffee00")){{
            localizedName = "Poligen";
            coolant = true; heatCapacity = 1.6f; gas = true;
        }};

        petragen = new Liquid("Petragen", Color.valueOf("ffee00")){{
            localizedName = "Petragen";
            coolant = false;
            gas = true;
        }};
        // End of liquid, next one for drills - block
        
        cophalastDrill = new Drill("Cophalast-drill") {{
            localizedName = "Cophalast Drill";
            size = 2; tier = 2; drillTime = 600f;
            requirements(Category.prodution, with(Cophalast, 10));
        }};
        
        trinaxideBeam = new BeamDrill("Trinaxide-beam") {{
            localizedName= "Trinaxide Beam Drill";
            size = 2; tier = 2; drillTime = 600f;
            requirements(Category.prodution, with(cophalast, 10, trinaxide, 10, krutrok, 10));
            consumePower(1f);
            consumeCoolant(6, true, true).boost();
        }};
        
        xenathiumDrill = new Drill("Xenathium-drill") {{
            localizedName = "Xenathium Drill";
            size = 3; tier = 5; drillTime = 600f;
            requirements(Category.prodution, with(cophalast, 10, trinaxide, 10, krutrok, 10, xenathium, 10));
            consumePower(5f);
            consumeCoolant(6, true, true).boost();
        }};
        
        hilimeniLaserBeam = new BeamDrill("Hilimeni-beam") {{
            localizedName = "Hilimeni Laser";
            size = 3; tier = 5; drillTime = 600f;
            requirements(Category.prodution, with(cophalast, 10, trinaxide, 10, krutrok, 10, hilimeni, 10));
            consumePower(5f);
            consumeCoolant(6, true, true).boost();
        }};
        
        
        hexademiaDrill = new Drill("Hexademia-drill") {{
            localizedName = "Hexademia Harderness Drill";
            size = 4; tier = 7; drillTime = 600f;
            requirements(Category.prodution, with(cophalast, 10, trinaxide, 10, krutrok, 10, xenathium, 10));
            consumePower(5f);
            consumeCoolant(6, true, true).boost();
        }};
        
        medraliDrill = new SolidPump("water-extractor"){{
            requirements(Category.prodution, with(cophalast, 10, trinaxide, 10));
            result = Liquids.water; pumpAmount = 0.11f;
            size = 2; liquidCapacity = 30f;
            attribute = Attribute.water;
            envRequired |= Env.groundWater;
            consumePower(1.5f);
        }};
        

        

        

        

        
        
        
        
    }
} 
