package neko.content;

import static mindustry.type.ItemStack.with;
import static neko.content.NekoBlocks.cophalastWall;
import static neko.content.NekoBlocks.hexademiaWall;
import static neko.content.NekoBlocks.xenathiumWall;
import static neko.content.NekoItemsAndLiquids.cophalast;
import static neko.content.NekoItemsAndLiquids.medrali;

import arc.struct.Seq;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.UnitTypes;
import mindustry.type.Category;
import mindustry.type.PayloadStack;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.blocks.payloads.Constructor;
import mindustry.world.blocks.payloads.PayloadConveyor;
import mindustry.world.blocks.payloads.PayloadMassDriver;
import mindustry.world.blocks.payloads.PayloadRouter;
import mindustry.world.blocks.units.Reconstructor;
import mindustry.world.blocks.units.UnitAssembler;
import mindustry.world.blocks.units.UnitAssemblerModule;
import mindustry.world.blocks.units.UnitFactory;

public class NekoUnit {
    public static Block tankFactory, mechFactory, aircraftFactory,
            heatRefabricator, shieldRefabricator, supportRefabricator,
            quatumnAssembler, atomicAssembler, shipAssembler,
            AtierModule, StierModule, unitRepairTower,
            cophalastPayload, cophalastPayloadRouter,
            xenathiumPayloadDriver, xenathiumConstructor;

    public static void load() {
        // unit factory, for convenient
        tankFactory = new UnitFactory("Tank-factory") {
            {
                localizedName = "Tank Factory";
                requirements(Category.units, with(cophalast, 10));
                plans = Seq.with(
                        new UnitPlan(UnitTypes.dagger, 60f * 15, with(Items.silicon, 10, Items.lead, 10)),
                        new UnitPlan(UnitTypes.crawler, 60f * 10, with(Items.silicon, 8, Items.coal, 10)),
                        new UnitPlan(UnitTypes.nova, 60f * 40,
                                with(Items.silicon, 30, Items.lead, 20, Items.titanium, 20)),
                        new UnitPlan(UnitTypes.stell, 60f * 35f, with(Items.beryllium, 40, Items.silicon, 50)));
                size = 3;
                consumePower(1.2f);
            }
        };

        mechFactory = new UnitFactory("Mech-factory") {
            {
                localizedName = "Mech Factory";
                requirements(Category.units, with(cophalast, 10));
                plans = Seq.with(
                        new UnitPlan(UnitTypes.nova, 60f * 40,
                                with(Items.silicon, 30, Items.lead, 20, Items.titanium, 20)),
                        new UnitPlan(UnitTypes.merui, 60f * 40f, with(Items.beryllium, 50, Items.silicon, 70)));
                size = 3;
                consumePower(1.2f);
            }
        };

        aircraftFactory = new UnitFactory("Aircraft-factory") {
            {
                localizedName = "Aircraft Factory";
                requirements(Category.units, with(cophalast, 10));
                plans = Seq.with(
                        new UnitPlan(UnitTypes.flare, 60f * 15, with(Items.silicon, 15)),
                        new UnitPlan(UnitTypes.mono, 60f * 35, with(Items.silicon, 30, Items.lead, 15)),
                        new UnitPlan(UnitTypes.elude, 60f * 40f, with(Items.graphite, 50, Items.silicon, 70)));
                size = 3;
                consumePower(1.2f);
            }
        };

        heatRefabricator = new Reconstructor("Heat-refabricator") {
            {
                localizedName = "Heat Refabricator";
                requirements(Category.units, with(cophalast, 10));

                size = 3;
                consumePower(3f);
                consumeLiquid(medrali, 3f / 60f);
                consumeItems(with(cophalast, 10));

                constructTime = 60f * 30f;
                researchCostMultiplier = 0.75f;

                upgrades.addAll(
                        new UnitType[] { UnitTypes.dagger, UnitTypes.mace },
                        new UnitType[] { UnitTypes.crawler, UnitTypes.atrax },
                        new UnitType[] { UnitTypes.elude, UnitTypes.avert });
            }
        };

        shieldRefabricator = new Reconstructor("Shield-refabricator") {
            {
                localizedName = "Shield Refabricator";
                requirements(Category.units, with(cophalast, 10));

                size = 3;
                consumePower(3f);
                consumeLiquid(medrali, 3f / 60f);
                consumeItems(with(cophalast, 10));

                constructTime = 60f * 30f;
                researchCostMultiplier = 0.75f;

                upgrades.addAll(
                        new UnitType[] { UnitTypes.stell, UnitTypes.locus },
                        new UnitType[] { UnitTypes.merui, UnitTypes.cleroi },
                        new UnitType[] { UnitTypes.flare, UnitTypes.horizon });
            }
        };

        supportRefabricator = new Reconstructor("Support-refabricator") {
            {
                localizedName = "Support Refabricator";
                requirements(Category.units, with(cophalast, 10));

                size = 3;
                consumePower(3f);
                consumeLiquid(medrali, 3f / 60f);
                consumeItems(with(cophalast, 10));

                constructTime = 60f * 30f;
                researchCostMultiplier = 0.75f;

                upgrades.addAll(
                        new UnitType[] { UnitTypes.nova, UnitTypes.pulsar },
                        new UnitType[] { UnitTypes.mono, UnitTypes.poly });
            }
        };

        quatumnAssembler = new UnitAssembler("Quantumn-assembler") {
            {
                localizedName = "Quantumn Assembler";
                requirements(Category.units,
                        with(Items.thorium, 500, Items.oxide, 150, Items.carbide, 80, Items.silicon, 500));

                size = 5;
                plans.add(
                        new AssemblerUnitPlan(UnitTypes.vanquish, 60f * 50f,
                                PayloadStack.list(UnitTypes.stell, 4, Blocks.tungstenWallLarge, 10)),
                        new AssemblerUnitPlan(UnitTypes.conquer, 60f * 60f * 3f,
                                PayloadStack.list(UnitTypes.locus, 6, Blocks.carbideWallLarge, 20)));
                areaSize = 13;
                researchCostMultiplier = 0.4f;

                consumePower(3f);
                consumeLiquid(Liquids.cyanogen, 9f / 60f);
            }
        };

        atomicAssembler = new UnitAssembler("Atomic-assembler") {
            {
                localizedName = "Atomic Assembler";
                requirements(Category.units,
                        with(Items.thorium, 500, Items.oxide, 150, Items.carbide, 80, Items.silicon, 500));

                size = 5;
                plans.add(
                        new AssemblerUnitPlan(UnitTypes.vanquish, 60f * 50f,
                                PayloadStack.list(UnitTypes.stell, 4, Blocks.tungstenWallLarge, 10)),
                        new AssemblerUnitPlan(UnitTypes.conquer, 60f * 60f * 3f,
                                PayloadStack.list(UnitTypes.locus, 6, Blocks.carbideWallLarge, 20)));
                areaSize = 13;
                researchCostMultiplier = 0.4f;

                consumePower(3f);
                consumeLiquid(Liquids.cyanogen, 9f / 60f);
            }
        };

        shipAssembler = new UnitAssembler("Ship-assembler") {
            {
                localizedName = "Ship Assembly";
                requirements(Category.units,
                        with(Items.thorium, 500, Items.oxide, 150, Items.carbide, 80, Items.silicon, 500));

                size = 5;
                plans.add(
                        new AssemblerUnitPlan(UnitTypes.vanquish, 60f * 50f,
                                PayloadStack.list(UnitTypes.stell, 4, Blocks.tungstenWallLarge, 10)),
                        new AssemblerUnitPlan(UnitTypes.conquer, 60f * 60f * 3f,
                                PayloadStack.list(UnitTypes.locus, 6, Blocks.carbideWallLarge, 20)));
                areaSize = 13;
                researchCostMultiplier = 0.4f;

                consumePower(3f);
                consumeLiquid(Liquids.cyanogen, 9f / 60f);
            }
        };

        AtierModule = new UnitAssemblerModule("A-module") {
            {
                localizedName = "Tier A Assembly Module";
                requirements(Category.units,
                        with(Items.carbide, 300, Items.thorium, 500, Items.oxide, 200, Items.phaseFabric, 400));
                consumePower(4f);

                researchCostMultiplier = 0.75f;
                size = 5;
                tier = 1;
            }
        };

        StierModule = new UnitAssemblerModule("S-module") {
            {
                localizedName = "Tier S Assembly Module";
                requirements(Category.units,
                        with(Items.carbide, 300, Items.thorium, 500, Items.oxide, 200, Items.phaseFabric, 400));
                consumePower(6f);

                researchCostMultiplier = 0.75f;
                size = 5;
                tier = 2;
            }
        };

        cophalastPayload = new PayloadConveyor("Cophalast-payload") {
            {
                localizedName = "Cophalast Payload Conveyor";
                requirements(Category.units, with(Items.graphite, 10, Items.copper, 10));
                canOverdrive = false;
            }
        };

        cophalastPayloadRouter = new PayloadRouter("Cophalast-payload-router") {
            {
                localizedName = "Cophalast Payload Router";
                requirements(Category.units, with(Items.graphite, 15, Items.copper, 10));
                canOverdrive = false;
            }
        };

        xenathiumPayloadDriver = new PayloadMassDriver("Xenathium-payload-driver") {
            {
                localizedName = "Xenathium Payload Mass Driver";
                requirements(Category.units, with(Items.tungsten, 120, Items.silicon, 120, Items.graphite, 50));
                size = 3;
                reload = 130f;
                chargeTime = 90f;
                range = 700f;
                maxPayloadSize = 2.5f;
                fogRadius = 5;
                consumePower(0.5f);
            }
        };

        xenathiumConstructor = new Constructor("Xenathium-constructor") {
            {
                localizedName = "Xenathium Constructor";
                requirements(Category.units, with(Items.silicon, 100, Items.beryllium, 150, Items.tungsten, 80));
                hasPower = true;
                buildSpeed = 0.6f;
                consumePower(2f);
                size = 3;
                // TODO expand this list
                filter = Seq.with(cophalastWall, xenathiumWall, hexademiaWall);
            }
        };
    }
}
