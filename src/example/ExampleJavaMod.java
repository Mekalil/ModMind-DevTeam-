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
import mindustry.type.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class ExampleJavaMod extends Mod{

    public static Item cophalast, trinaxide, monoglox, polamenis, xenathium, hilimeni, hexademia, kructrok, nasmehro, flukemasd;
    public static Liquid medrali, poligen, petragen;
    public static Block cophalastDrill, trinaxideBeam, xenathiumDrill, hilimeniLaserBeam, hexademiaDrill, medraliDrill;
    public static Block electrolysis, kructrokFactory, nasmehroFactory, flukemasdFactory;
    public static Block diffGen, hilimeniGen, atomicGen;
    
    

    public ExampleJavaMod(){
    }

    @Override
    public void loadContent(){
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
            requirements(Category.production, with(cophalast, 10));
        }};
        
        trinaxideBeam = new BeamDrill("Trinaxide-beam") {{
            localizedName= "Trinaxide Beam Drill";
            size = 2; tier = 2; drillTime = 600f;
            requirements(Category.production, with(cophalast, 10, trinaxide, 10, kructrok, 10));
            consumePower(1f);
            consumeCoolant(6, true, true).boost();
        }};
        
        xenathiumDrill = new Drill("Xenathium-drill") {{
            localizedName = "Xenathium Drill";
            size = 3; tier = 5; drillTime = 600f;
            requirements(Category.production, with(cophalast, 10, trinaxide, 10, kructrok, 10, xenathium, 10));
            consumePower(5f);
            consumeCoolant(6, true, true).boost();
        }};
        
        hilimeniLaserBeam = new BeamDrill("Hilimeni-beam") {{
            localizedName = "Hilimeni Laser";
            size = 3; tier = 5; drillTime = 600f;
            requirements(Category.production, with(cophalast, 10, trinaxide, 10, kructrok, 10, hilimeni, 10));
            consumePower(5f);
            consumeCoolant(6, true, true).boost();
        }};
        
        
        hexademiaDrill = new Drill("Hexademia-drill") {{
            localizedName = "Hexademia Harderness Drill";
            size = 4; tier = 7; drillTime = 600f;
            requirements(Category.production, with(cophalast, 10, trinaxide, 10, kructrok, 10, xenathium, 10));
            consumePower(5f);
            consumeCoolant(6, true, true).boost();
        }};
        
        medraliDrill = new SolidPump("Medrali-extractor"){{
            requirements(Category.production, with(cophalast, 10, trinaxide, 10));
            result = medrali; pumpAmount = 5f;
            localizedName = "Medrali extractor";
            size = 2; liquidCapacity = 600f;
            attribute = Attribute.water;
            envRequired |= Env.groundWater;
            consumeItem(polamenis);
        }};
        
        // end of drill, next factorys:
        
        electrolysis = new GenericCrafter("Electrolysis-plant"){{
            localizedName = "Eletrolysis Plant";
            requirements(Category.crafting, with(cophalast, 10, trinaxide, 10));
            size = 3; craftTime = 10f; rotate = true;
            invertFlip = true; liquidCapacity = 50f;

            consumeLiquid(medrali, 10f / 60f);
            consumePower(1f);

            regionRotated1 = 3;
            outputLiquids = LiquidStack.with(poligen, 4f/ 60f, petragen, 6f/ 60f);
            liquidOutputDirections = new int[]{1, 3};
        }};
        
        kructrokFactory = new GenericCrafter("Kructrok-factory"){{
            localizedName = "Kructrok Refining Furnace";
            requirements(Category.crafting, with(cophalast, 10, trinaxide, 10));

            outputItem = new ItemStack(kructrok, 3);
            craftTime = 90f; size = 3;

            consumeItems(polamenis, 3, monoglox, 5);
            consumePower(1f);
        }};
        
        nasmehroFactory = new GenericCrafter("Nasmehro-factory"){{
            localizedName = "Nasmehro Alloy Mixer Factory";
            requirements(Category.crafting, with(cophalast, 10, trinaxide, 10));

            outputItem = new ItemStack(nasmehro, 3);
            craftTime = 90f; size = 4;

            consumeItems(trinaxide, 2, hilimeni, 1, xenathium, 1, kructrok, 1);
            consumePower(1f);
        }};
        
        flukemasdFactory = new GenericCrafter("Flukemasd-factory"){{
            localizedName = "Flukemasd Synthetic Fiber Refining Factory";
            requirements(Category.crafting, with(cophalast, 10, trinaxide, 10));

            outputItem = new ItemStack(flukemasd, 3);
            craftTime = 90f; size = 5;

            consumeItems(hexademia, 3, monoglox, 10);
            consumePower(1f);
        }};
        
        diffGen = new ConsumeGenerator("Diff-gen"){{
            localizedName = "Different Generator (f)";
            requirements(Category.power, with(cophalast, 10, trinaxide, 10));
            powerProduction = 18f; itemDuration = 60f;
            hasLiquids = true; hasItems = true; size = 5;

            consumeItem(polamenis);
            consumeLiquid(medrali, 6f/ 60f);
        }};
        
        hilimeniGen = new NuclearReactor("Hilimeni-gen"){{
            localizedName = "Hilimeni Energy Core Generator";
            requirements(Category.power, with(cophalast, 10));
            size = 5; itemDuration = 600f; powerProduction = 50f;

            consumeItem(hilimeni); itemCapacity = 50;
        }};

        atomicGen = new ImpactReactor("Atomic Generator"){{
            requirements(Category.power, with(cophalast, 10));
            size = 6; powerProduction = 200f; itemDuration = 60f;
            liquidCapacity = 60f; itemCapacity = 20;

            consumePower(25f); consumeLiquid(petragen, 1f);
        }};

        

        

        

        
        
        
        
    }
} 
