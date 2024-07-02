package neko.content;

import static mindustry.type.ItemStack.with;
import static neko.content.NekoItemsAndLiquids.cophalast;
import static neko.content.NekoItemsAndLiquids.flukemasd;
import static neko.content.NekoItemsAndLiquids.hexademia;
import static neko.content.NekoItemsAndLiquids.hilimeni;
import static neko.content.NekoItemsAndLiquids.kructrok;
import static neko.content.NekoItemsAndLiquids.medrali;
import static neko.content.NekoItemsAndLiquids.monoglox;
import static neko.content.NekoItemsAndLiquids.nasmehro;
import static neko.content.NekoItemsAndLiquids.petragen;
import static neko.content.NekoItemsAndLiquids.polamenis;
import static neko.content.NekoItemsAndLiquids.poligen;
import static neko.content.NekoItemsAndLiquids.trinaxide;
import static neko.content.NekoItemsAndLiquids.xenathium;

import arc.graphics.Color;
import mindustry.content.UnitTypes;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.BuildTurret;
import mindustry.world.blocks.defense.RegenProjector;
import mindustry.world.blocks.defense.ShockwaveTower;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.distribution.BufferedItemBridge;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.distribution.MassDriver;
import mindustry.world.blocks.distribution.OverflowGate;
import mindustry.world.blocks.distribution.Sorter;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.liquid.LiquidJunction;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.blocks.logic.LogicBlock;
import mindustry.world.blocks.logic.LogicDisplay;
import mindustry.world.blocks.logic.MemoryBlock;
import mindustry.world.blocks.logic.MessageBlock;
import mindustry.world.blocks.power.Battery;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.ImpactReactor;
import mindustry.world.blocks.power.NuclearReactor;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.production.BeamDrill;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.SolidPump;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawGlowRegion;
import mindustry.world.draw.DrawLiquidTile;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawPulseShape;
import mindustry.world.draw.DrawRegion;
import mindustry.world.draw.DrawShape;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.Env;

public class NekoBlocks {
    public static Block // drill

    cophalastDrill, xenathiumDrill, hexademiaDrill,
            trinaxideBeam, hilimeniLaserBeam,
            medraliDrill,

            // transport
            cophalastConveyor, xenathiumConveyor, cophalastBridge,
            cophalastFlow, cophalastUnderFlow, cophalastSorter,
            xenathiumDriver, hexademiaDriver,

            // liquid
            cophalastConduit, xenathiumConduit, cophalastLiquidBridge,
            cophalastLiquidRouter, cophalastLiquidContainer,
            cophalastLiquidTank,

            // power
            smallNode, largeNode,
            diffGen, hilimeniGen, atomicGen, battery,

            // defensive (wall)
            cophalastWall, cophalastBigWall, xenathiumWall, xenathiumBigWall,
            hexademiaWall, hexademiaBigWall, nasmehroWall, nasmehroBigWall,
            flukemashWall, flukemasdBigWall,

            // factorys
            electrolysis, kructrokFactory, nasmehroFactory, flukemasdFactory,

            // effect
            menethik, mantimela, potronagas,
            repairField, bigRepairField, shieldFileld, damageField,
            buildTower, smallContainer, bigContainer, unloader,

            // logic
            smallProcessor, processor, bigProcessor,
            dataCell, dataBank, display, messsge;

    public static void load() {
        // region drill
        cophalastDrill = new Drill("Cophalast-drill") {
            {
                localizedName = "Cophalast Drill";
                size = 2;
                tier = 2;
                drillTime = 600f;
                requirements(Category.production, with(cophalast, 10));
            }
        };

        trinaxideBeam = new BeamDrill("Trinaxide-beam") {
            {
                localizedName = "Trinaxide Beam Drill";
                size = 2;
                tier = 2;
                drillTime = 600f;
                requirements(Category.production, with(cophalast, 10, trinaxide, 10, kructrok, 10));
                consumePower(1f);
            }
        };

        xenathiumDrill = new Drill("Xenathium-drill") {
            {
                localizedName = "Xenathium Drill";
                size = 3;
                tier = 5;
                drillTime = 600f;
                requirements(Category.production, with(cophalast, 10, trinaxide, 10, kructrok, 10, xenathium, 10));
                consumePower(5f);
            }
        };

        hilimeniLaserBeam = new BeamDrill("Hilimeni-beam") {
            {
                localizedName = "Hilimeni Laser";
                size = 3;
                tier = 5;
                drillTime = 600f;
                requirements(Category.production, with(cophalast, 10, trinaxide, 10, kructrok, 10, hilimeni, 10));
                consumePower(5f);
            }
        };

        hexademiaDrill = new Drill("Hexademia-drill") {
            {
                localizedName = "Hexademia Harderness Drill";
                size = 4;
                tier = 7;
                drillTime = 600f;
                requirements(Category.production, with(cophalast, 10, trinaxide, 10, kructrok, 10, xenathium, 10));
                consumePower(5f);
            }
        };

        medraliDrill = new SolidPump("Medrali-extractor") {
            {
                requirements(Category.production, with(cophalast, 10, trinaxide, 10));
                result = medrali;
                pumpAmount = 1f;
                localizedName = "Medrali extractor";
                size = 2;
                liquidCapacity = 600f;
                attribute = Attribute.water;
                envRequired |= Env.groundWater;
                consumeItem(polamenis);
            }
        };

        // region transport
        cophalastConveyor = new Conveyor("Cophalast-conveyor") {
            {
                localizedName = "Cophalast Conveyor";
                requirements(Category.distribution, with(cophalast, 1));
                health = 45;
                speed = 0.1f;
                displayedSpeed = 14f;
            }
        };

        xenathiumConveyor = new Conveyor("Xenathium-conveyor") {
            {
                localizedName = "Xenathium Conveyor";
                requirements(Category.distribution, with(cophalast, 1));
                health = 45;
                speed = 0.15f;
                displayedSpeed = 21f;
            }
        };

        cophalastSorter = new Sorter("Cophalast-sorter") {
            {
                localizedName = "Cophalast Sorter";
                requirements(Category.distribution, with(cophalast, 2));
            }
        };

        cophalastBridge = new BufferedItemBridge("Cophalast-bridge") {
            {
                localizedName = "Cophalast Bridge";
                requirements(Category.distribution, with(cophalast, 10));
                fadeIn = moveArrows = false;
                range = 6;
                speed = 100f;
                arrowSpacing = 6f;
                bufferCapacity = 25;
            }
        };

        cophalastFlow = new OverflowGate("Cophalast-flow") {
            {
                localizedName = "Cophalast Flow Gate";
                requirements(Category.distribution, with(cophalast, 5));
            }
        };

        cophalastUnderFlow = new OverflowGate("Cophalast-underflow") {
            {
                localizedName = "Cophalast Underflow Gate";
                requirements(Category.distribution, with(cophalast, 5));
                invert = true;
            }
        };

        xenathiumDriver = new MassDriver("Xenathium-driver") {
            {
                localizedName = "Xenathium Mass Driver";
                requirements(Category.distribution,
                        with(xenathium, 100, trinaxide, 50, kructrok, 50));
                size = 3;
                itemCapacity = 200;
                reload = 250f;
                range = 440f;
                consumePower(1.75f);
            }
        };

        hexademiaDriver = new MassDriver("Hexademia-driver") {
            {
                localizedName = "Hexademia Mass Driver";
                requirements(Category.distribution,
                        with(xenathium, 100, trinaxide, 50, kructrok, 50));
                size = 4;
                itemCapacity = 350;
                reload = 350f;
                range = 520f;
                consumePower(2.5f);
            }
        };

        // region liquid

        cophalastConduit = new Conduit("Cophalast-conduit") {
            {
                localizedName = "Cophalast Conduit";
                requirements(Category.liquid, with(cophalast, 2));
            }
        };

        xenathiumConduit = new Conduit("Xenathium-conduit") {
            {
                localizedName = "Xenathium Conduit";
                requirements(Category.liquid, with(xenathium, 2));
                liquidCapacity = 16f;
                liquidPressure = 1.025f;
            }
        };

        cophalastLiquidRouter = new LiquidRouter("Cophalast-liquid-router") {
            {
                localizedName = "Cophalast Router";
                requirements(Category.liquid, with(cophalast, 10));
                liquidCapacity = 20f;
                underBullets = true;
                solid = false;
            }
        };

        cophalastLiquidBridge = new LiquidJunction("Cophalast-liquid-bridge") {
            {
                localizedName = "Cophalast Bridge";
                requirements(Category.liquid, with(cophalast, 20));
                solid = false;
            }
        };

        cophalastLiquidContainer = new LiquidRouter("Cophalast-liquid-container") {
            {
                localizedName = "Cophalast Container";
                requirements(Category.liquid, with(cophalast, 200));
                liquidCapacity = 2000f;
                size = 2;
                solid = true;
            }
        };

        cophalastLiquidTank = new LiquidRouter("Cophalast-liquid-tank") {
            {
                localizedName = "Cophalast Tank";
                requirements(Category.liquid, with(cophalast, 400));
                liquidCapacity = 3200f;
                size = 3;
                solid = true;
            }
        };

        // region power

        diffGen = new ConsumeGenerator("Diff-gen") {
            {
                localizedName = "Different Generator (f)";
                requirements(Category.power, with(cophalast, 10, trinaxide, 10));
                powerProduction = 18f;
                itemDuration = 60f;
                hasLiquids = true;
                hasItems = true;
                size = 5;

                consumeItem(polamenis);
                consumeLiquid(medrali, 6f / 60f);
            }
        };

        hilimeniGen = new NuclearReactor("Hilimeni-gen") {
            {
                localizedName = "Hilimeni Energy Core Generator";
                requirements(Category.power, with(cophalast, 10));
                size = 5;
                itemDuration = 600f;
                powerProduction = 50f;

                consumeItem(hilimeni);
                itemCapacity = 50;
                consumeLiquid(poligen, 0.1f);
            }
        };

        atomicGen = new ImpactReactor("Atomic Generator") {
            {
                localizedName = "Atomic Generator";
                requirements(Category.power, with(cophalast, 10));
                size = 6;
                powerProduction = 200f;
                itemDuration = 60f;
                liquidCapacity = 300f;
                itemCapacity = 20;

                consumePower(25f);
                consumeLiquid(petragen, 1f);
            }
        };

        battery = new Battery("Battery") {
            {
                requirements(Category.power, with(cophalast, 10, trinaxide, 10));
                consumePowerBuffered(4000f);
                baseExplosiveness = 1f;
            }
        };

        smallNode = new PowerNode("Small-node") {
            {
                localizedName = "Small Node";
                requirements(Category.power, with(cophalast, 1, trinaxide, 3));
                maxNodes = 10;
                laserRange = 10;
            }
        };

        largeNode = new PowerNode("Large-node") {
            {
                localizedName = "Large Node";
                requirements(Category.power, with(cophalast, 10, trinaxide, 5, kructrok, 5));
                size = 2;
                maxNodes = 15;
                laserRange = 20f;
            }
        };

        // region defensive

        cophalastWall = new Wall("Cophalast-wall") {
            {
                localizedName = "Cophalast Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                envDisabled |= Env.scorching;
                size = 2;
            }
        };

        cophalastBigWall = new Wall("Cophalast-big-wall") {
            {
                localizedName = "Cophalast Big Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                envDisabled |= Env.scorching;
                size = 3;
            }
        };

        xenathiumWall = new Wall("Xenathium-wall") {
            {
                localizedName = "Xenathium Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                envDisabled |= Env.scorching;
                size = 2;
            }
        };

        xenathiumBigWall = new Wall("Xenathium-big-wall") {
            {
                localizedName = "Xenathium Big Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                envDisabled |= Env.scorching;
                size = 3;
            }
        };

        hexademiaWall = new Wall("Hexademia-wall") {
            {
                localizedName = "Hexademia Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                absorbLasers = true;
                envDisabled |= Env.scorching;
                size = 2;
            }
        };

        hexademiaBigWall = new Wall("Hexademia-big-wall") {
            {
                localizedName = "Hexademia Big Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                absorbLasers = true;
                envDisabled |= Env.scorching;
                size = 3;
            }
        };

        nasmehroWall = new Wall("Nasmehro-wall") {
            {
                localizedName = "Nasmehro Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                lightningChance = 0.5f;
                envDisabled |= Env.scorching;
                size = 2;
            }
        };

        nasmehroBigWall = new Wall("Nasmehro-big-wall") {
            {
                localizedName = "Nasmehro Big Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                lightningChance = 0.75f;
                envDisabled |= Env.scorching;
                size = 3;
            }
        };

        flukemashWall = new Wall("Flukemasd-wall") {
            {
                localizedName = "Flukemasd Wall";
                requirements(Category.defense, with(cophalast, 10));
                health = 80;
                chanceDeflect = 30f;
                flashHit = true;
                envDisabled |= Env.scorching;
                size = 2;
            }
        };

        flukemasdBigWall = new Wall("Flukemasd-big-wall") {
            {
                localizedName = "Flukemasd Big Wall";
                requirements(Category.defense, with(cophalast, 10));
                chanceDeflect = 60f;
                flashHit = true;
                health = 80;
                envDisabled |= Env.scorching;
                size = 3;
            }
        };

        // region factory

        electrolysis = new GenericCrafter("Electrolysis") {
            {
                localizedName = "Eletrolysis Plant";
                requirements(Category.crafting, with(cophalast, 10, trinaxide, 10));
                size = 3;
                craftTime = 10f;
                rotate = true;
                invertFlip = true;
                liquidCapacity = 50f;

                consumeLiquid(medrali, 10f / 60f);
                consumePower(1f);

                regionRotated1 = 3;
                outputLiquids = LiquidStack.with(poligen, 4f / 60f, petragen, 6f / 60f);
                liquidOutputDirections = new int[] { 1, 3 };
            }
        };

        kructrokFactory = new GenericCrafter("Kructrok-factory") {
            {
                localizedName = "Kructrok Refining Furnace";
                requirements(Category.crafting, with(cophalast, 10, trinaxide, 10));

                outputItem = new ItemStack(kructrok, 3);
                craftTime = 90f;
                size = 3;

                consumeItems(with(polamenis, 3, monoglox, 5));
                consumePower(1f);
            }
        };

        nasmehroFactory = new GenericCrafter("Nasmehro-factory") {
            {
                localizedName = "Nasmehro Alloy Mixer Factory";
                requirements(Category.crafting, with(cophalast, 10, trinaxide, 10));

                outputItem = new ItemStack(nasmehro, 3);
                craftTime = 90f;
                size = 4;

                consumeItems(with(trinaxide, 2, hilimeni, 1, xenathium, 1, kructrok, 1));
                consumePower(1f);
            }
        };

        flukemasdFactory = new GenericCrafter("Flukemasd-factory") {
            {
                localizedName = "Flukemasd Synthetic Fiber Refining Factory";
                requirements(Category.crafting, with(cophalast, 10, trinaxide, 10));

                outputItem = new ItemStack(flukemasd, 3);
                craftTime = 90f;
                size = 5;

                consumeItems(with(hexademia, 3, monoglox, 10));
                consumePower(1f);
            }
        };

        // region effect
        menethik = new CoreBlock("Menethik") {
            {
                localizedName = "Core: Menethik Platform";
                requirements(Category.effect, with(cophalast, 4000));

                isFirstTier = true;
                unitType = UnitTypes.mega;
                health = 8000;
                itemCapacity = 8000;
                size = 5;
                armor = 2000f;

                alwaysUnlocked = true;
                incinerateNonBuildable = true;
                requiresCoreZone = true;
                thrusterLength = 40 / 4f;

                buildCostMultiplier = 1f;

                unitCapModifier = 24;
            }
        };

        mantimela = new CoreBlock("Mantimela") {
            {
                localizedName = "Core: Mantimela HQ";
                requirements(Category.effect, with(cophalast, 4000, xenathium, 4000, kructrok, 4000, nasmehro, 1000));

                unitType = UnitTypes.mega;
                health = 22000;
                itemCapacity = 16000;
                size = 6;
                armor = 2500f;

                alwaysUnlocked = true;
                incinerateNonBuildable = true;
                requiresCoreZone = true;
                thrusterLength = 48 / 4f;

                buildCostMultiplier = 1f;

                unitCapModifier = 48;
            }
        };

        potronagas = new CoreBlock("Potronagas") {
            {
                localizedName = "Core: Potronagas Planet";
                requirements(Category.effect,
                        with(cophalast, 4000, kructrok, 4000, xenathium, 4000, hexademia, 4000, nasmehro, 2000));

                unitType = UnitTypes.mega;
                health = 38000;
                itemCapacity = 25000;
                size = 7;
                armor = 3000f;

                alwaysUnlocked = true;
                incinerateNonBuildable = true;
                requiresCoreZone = true;
                thrusterLength = 58 / 4f;

                buildCostMultiplier = 1f;

                unitCapModifier = 72;
            }
        };

        repairField = new RegenProjector("Repair-field") {
            {
                localizedName = "Repair Field";
                requirements(Category.effect, with(cophalast, 10, trinaxide, 10));
                size = 3;
                range = 30;
                healPercent = 20f / 60f;

                consumePower(1f);
                consumeLiquid(medrali, 1f / 60f);
                consumeItem(hilimeni).boost();

                Color col = Color.valueOf("8ca9e8");

                drawer = new DrawMulti(new DrawRegion("-bottom"),
                        new DrawLiquidTile(medrali, 9f / 4f),
                        new DrawDefault(), new DrawGlowRegion() {
                            {
                                color = Color.sky;
                            }
                        }, new DrawPulseShape(false) {
                            {
                                layer = Layer.effect;
                                color = col;
                            }
                        }, new DrawShape() {
                            {
                                layer = Layer.effect;
                                radius = 3.5f;
                                useWarmupRadius = true;
                                timeScl = 2f;
                                color = col;
                            }
                        });
            }
        };

        bigRepairField = new RegenProjector("Big-repair-field") {
            {
                localizedName = "Big Repair Field";
                requirements(Category.effect, with(cophalast, 10, trinaxide, 10));
                size = 4;
                range = 40;
                healPercent = 20f / 60f;

                consumePower(1f);
                consumeLiquid(petragen, 1f / 60f);
                consumeItem(hilimeni).boost();

                Color col = Color.valueOf("8ca9e8");

                drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(medrali, 9f / 4f),
                        new DrawDefault(), new DrawGlowRegion() {
                            {
                                color = Color.sky;
                            }
                        }, new DrawPulseShape(false) {
                            {
                                layer = Layer.effect;
                                color = col;
                            }
                        }, new DrawShape() {
                            {
                                layer = Layer.effect;
                                radius = 3.5f;
                                useWarmupRadius = true;
                                timeScl = 2f;
                                color = col;
                            }
                        });
            }
        };

        damageField = new ShockwaveTower("Damage-field") {
            {
                localizedName = "Damage Projectile Field";
                requirements(Category.effect, with(xenathium, 10, hilimeni, 10));
                size = 4;
                consumeLiquids(LiquidStack.with(medrali, 1.5f / 60f));
                consumeItem(hilimeni);
                consumePower(100f / 60f);
                range = 300f;
                reload = 80f;
            }
        };

        buildTower = new BuildTurret("Build-tower") {
            {
                localizedName = "Build Tower";
                requirements(Category.effect, with(xenathium, 10));
                outlineColor = Pal.darkOutline;

                range = 280f;
                size = 4;
                buildSpeed = 1f;

                consumePower(9f);
                consumeLiquid(poligen, 3f / 60f);
            }
        };

        smallContainer = new StorageBlock("Small-container") {
            {
                localizedName = "Small Container";
                requirements(Category.effect, with(cophalast, 10, kructrok, 10));
                size = 2;
                itemCapacity = 1000;
                scaledHealth = 55;
            }
        };

        bigContainer = new StorageBlock("Big-container") {
            {
                localizedName = "Big Container";
                requirements(Category.effect, with(cophalast, 10, kructrok, 10, xenathium, 10));
                size = 3;
                itemCapacity = 2000;
                scaledHealth = 55;
            }
        };

        unloader = new Unloader("Unloader") {
            {
                localizedName = "Unloader";
                requirements(Category.effect, with(cophalast, 10));
                speed = 60f / 11f;
                group = BlockGroup.transportation;
            }
        };

        // region logic
        smallProcessor = new LogicBlock("Small-processor") {
            {
                localizedName = "Small Processor";
                requirements(Category.logic, with(cophalast, 10, trinaxide, 10, kructrok, 10));

                instructionsPerTick = 4;
                range = 8 * 22;
                size = 2;
            }
        };

        processor = new LogicBlock("Processor") {
            {
                localizedName = "Standard Processor";
                requirements(Category.logic, with(cophalast, 10, trinaxide, 10, kructrok, 10, xenathium, 10));

                instructionsPerTick = 8;
                range = 8 * 30;
                size = 3;
            }
        };

        bigProcessor = new LogicBlock("Big-processor") {
            {
                localizedName = "Big Processor";
                requirements(Category.logic,
                        with(cophalast, 10, trinaxide, 10, kructrok, 10, xenathium, 10, hexademia, 10));

                instructionsPerTick = 16;
                range = 8 * 35;
                size = 4;
            }
        };

        dataCell = new MemoryBlock("Data-cell") {
            {
                localizedName = "Data Cell";
                requirements(Category.logic, with(cophalast, 10, trinaxide, 10, kructrok, 10));

                memoryCapacity = 128;
                size = 2;
            }
        };

        dataBank = new MemoryBlock("Data-bank") {
            {
                localizedName = "Data Bank";
                requirements(Category.logic, with(xenathium, 10, trinaxide, 10, kructrok, 10));

                memoryCapacity = 256;
                size = 3;
            }
        };

        display = new LogicDisplay("Display") {
            {
                localizedName = "Display";
                requirements(Category.logic, with(cophalast, 10, trinaxide, 10, kructrok, 10));

                displaySize = 360;
                size = 12;
            }
        };

        messsge = new MessageBlock("message") {
            {
                localizedName = "Ice Message";
                requirements(Category.logic, with(cophalast, 1));
            }
        };
    }
}
