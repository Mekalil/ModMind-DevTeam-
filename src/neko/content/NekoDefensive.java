package neko.content;

import static mindustry.type.ItemStack.with;
import static neko.content.NekoItemsAndLiquids.cophalast;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.abilities.MoveEffectAbility;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.ExplosionBulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.bullet.RailBulletType;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.part.DrawPart.PartProgress;
import mindustry.entities.part.RegionPart;
import mindustry.entities.part.ShapePart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.entities.pattern.ShootSummon;
import mindustry.gen.Sounds;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.Weapon;
import mindustry.type.unit.MissileUnitType;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.draw.DrawTurret;

public class NekoDefensive {
    public static Block auctor, dustria, agatias, novolary, erucas, ginquis, ares;

    public static DrawTurret ammoBarrelOutEffect;

    public static void load() {
        ammoBarrelOutEffect = new DrawTurret() {
            {
                for (int i = 0; i < 2; i++) {
                    int f = i;
                    parts.add(new RegionPart("-barrel-" + (i == 0 ? "l" : "r")) {
                        {
                            progress = PartProgress.recoil;
                            recoilIndex = f;
                            under = true;
                            moveY = -1.5f;
                        }
                    });
                }
            }
        };

        auctor = new ItemTurret("Auctor") {
            {
                localizedName = "Auctor";
                requirements(Category.turret, with(cophalast, 10));

                ammo(
                        cophalast, new BasicBulletType(4f, 100) {
                            {
                                width = 10f;
                                height = 14f;
                                lifetime = 60f;
                                ammoMultiplier = 2;
                            }
                        });

                drawer = ammoBarrelOutEffect;

                reload = 20;
                range = 110;
                health = 250;
                inaccuracy = 2f;
                rotateSpeed = 10f;
                ammoUseEffect = Fx.casing1;

                recoil = 0.5f;
                recoil = 2f;

                shootY = 3f;
                shootCone = 15f;
                coolant = consumeCoolant(0.1f);
            }
        };

        dustria = new ItemTurret("Dustria") {
            {
                localizedName = "Dustria";
                requirements(Category.turret, with(cophalast, 10));

                ammo(
                        cophalast, new BasicBulletType(4f, 100) {
                            {
                                width = 10f;
                                height = 14f;
                                lifetime = 60f;
                                ammoMultiplier = 2;
                                splashDamageRadius = 20f;
                                splashDamage = 30f * 1.5f;
                            }
                        });

                drawer = ammoBarrelOutEffect;

                reload = 20;
                range = 110;
                health = 250;
                inaccuracy = 2f;
                rotateSpeed = 10f;
                ammoUseEffect = Fx.casing1;
                size = 2;

                recoil = 0.5f;
                recoil = 2f;
                shoot.shots = 4;
                shoot.shotDelay = 3f;

                shootY = 2f;
                shootCone = 15f;
                coolant = consumeCoolant(0.1f);
            }
        };

        agatias = new ItemTurret("Agatias") {
            {
                localizedName = "Agatias";
                requirements(Category.turret, with(cophalast, 10));

                ammo(
                        cophalast, new BasicBulletType(4f, 100) {
                            {
                                width = 10f;
                                height = 14f;
                                lifetime = 60f;
                                ammoMultiplier = 2;
                                splashDamageRadius = 20f;
                                splashDamage = 30f * 1.5f;
                                despawnEffect = hitEffect = new ExplosionEffect() {
                                    {
                                        waveColor = Pal.surge;
                                        smokeColor = Color.gray;
                                        sparkColor = Pal.sap;
                                        waveStroke = 4f;
                                        waveRad = 40f;
                                    }
                                };
                            }
                        });

                drawer = ammoBarrelOutEffect;

                reload = 20;
                range = 110;
                health = 250;
                inaccuracy = 2f;
                rotateSpeed = 10f;
                ammoUseEffect = Fx.casing1;
                size = 4;

                recoil = 0.5f;
                recoil = 2f;
                shoot = new ShootAlternate() {
                    {
                        spread = 4.7f;
                        shots = 3;
                        barrels = 4;
                    }
                };
                shoot.shots = 1;
                shoot.shotDelay = 3f;

                shootY = 3f;
                shootCone = 15f;
                coolant = consumeCoolant(0.1f);
            }
        };

        novolary = new ItemTurret("Novolary") {
            {
                localizedName = "Novolary";
                requirements(Category.turret, with(cophalast, 10));

                ammo(
                        cophalast, new BasicBulletType(4f, 100) {
                            {
                                width = 10f;
                                height = 14f;
                                lifetime = 60f;
                                ammoMultiplier = 2;
                                splashDamageRadius = 20f;
                                splashDamage = 30f * 1.5f;
                                homingPower = 0.12f;
                            }
                        });

                drawer = ammoBarrelOutEffect;

                reload = 20;
                range = 110;
                health = 250;
                inaccuracy = 2f;
                rotateSpeed = 10f;
                ammoUseEffect = Fx.casing1;
                size = 4;

                recoil = 0.5f;
                recoil = 2f;
                shoot = new ShootAlternate() {
                    {
                        spread = 4.7f;
                        shots = 4;
                        barrels = 2;
                    }
                };
                shoot.shots = 4;
                shoot.shotDelay = 3f;
                targetGround = false;
                shootY = 3f;
                shootCone = 15f;
                coolant = consumeCoolant(0.1f);
            }
        };

        erucas = new ItemTurret("Erucas") {
            {
                localizedName = "Erucas";
                requirements(Category.turret, with(cophalast, 10));

                ammo(
                        Items.carbide, new BasicBulletType(0f, 1) {
                            {
                                shootEffect = Fx.shootBig;
                                smokeEffect = Fx.shootSmokeMissile;
                                ammoMultiplier = 1f;

                                spawnUnit = new MissileUnitType("Neko-missile") {
                                    {
                                        width = 176f;
                                        height = 323f;
                                        speed = 4.6f;
                                        maxRange = 6f;
                                        lifetime = 60f * 5.5f;
                                        outlineColor = Pal.darkOutline;
                                        engineColor = trailColor = Pal.redLight;
                                        engineLayer = Layer.effect;
                                        engineSize = 3.1f;
                                        engineOffset = 10f;
                                        rotateSpeed = 0.25f;
                                        trailLength = 18;
                                        missileAccelTime = 50f;
                                        lowAltitude = true;
                                        loopSound = Sounds.missileTrail;
                                        loopSoundVolume = 0.6f;
                                        deathSound = Sounds.largeExplosion;
                                        targetAir = false;
                                        targetUnderBlocks = false;
                                        fogRadius = 6f;

                                        health = 210;

                                        weapons.add(new Weapon() {
                                            {
                                                shootCone = 360f;
                                                mirror = false;
                                                reload = 1f;
                                                deathExplosionEffect = Fx.massiveExplosion;
                                                shootOnDeath = true;
                                                shake = 10f;
                                                bullet = new ExplosionBulletType(1500f, 65f) {
                                                    {
                                                        hitColor = Pal.redLight;
                                                        shootEffect = new MultiEffect(
                                                                Fx.massiveExplosion, Fx.scatheExplosion,
                                                                Fx.scatheLight, new WaveEffect() {
                                                                    {
                                                                        lifetime = 10f;
                                                                        strokeFrom = 4f;
                                                                        sizeTo = 130f;
                                                                    }
                                                                });

                                                        collidesAir = false;
                                                        buildingDamageMultiplier = 0.25f;

                                                        ammoMultiplier = 1f;
                                                        fragLifeMin = 0.1f;
                                                        fragBullets = 7;
                                                        fragBullet = new ArtilleryBulletType(3.4f, 32) {
                                                            {
                                                                buildingDamageMultiplier = 0.3f;
                                                                drag = 0.02f;
                                                                hitEffect = Fx.massiveExplosion;
                                                                despawnEffect = Fx.scatheSlash;
                                                                knockback = 0.8f;
                                                                lifetime = 23f;
                                                                width = height = 18f;
                                                                collidesTiles = false;
                                                                splashDamageRadius = 40f;
                                                                splashDamage = 160f;
                                                                backColor = trailColor = hitColor = Pal.redLight;
                                                                frontColor = Color.white;
                                                                smokeEffect = Fx.shootBigSmoke2;
                                                                despawnShake = 7;
                                                                lightRadius = 30f;
                                                                lightColor = Pal.redLight;
                                                                lightOpacity = 0.5f;

                                                                trailLength = 20;
                                                                trailWidth = 3.5f;
                                                                trailEffect = Fx.none;
                                                            }
                                                        };
                                                    }
                                                };
                                            }
                                        });

                                        abilities.add(new MoveEffectAbility() {
                                            {
                                                effect = Fx.missileTrailSmoke;
                                                rotation = 180f;
                                                y = -9f;
                                                color = Color.grays(0.6f)
                                                        .lerp(Pal.redLight, 0.5f).a(0.4f);
                                                interval = 7f;
                                            }
                                        });
                                    }
                                };
                            }
                        });

                drawer = ammoBarrelOutEffect;

                reload = 20;
                range = 110;
                health = 250;
                inaccuracy = 2f;
                rotateSpeed = 10f;
                ammoUseEffect = Fx.casing1;
                size = 4;

                recoil = 0.5f;
                recoil = 2f;
                shoot = new ShootAlternate() {
                    {
                        spread = 4.7f;
                        shots = 4;
                        barrels = 4;
                    }
                };
                shoot.shots = 4;
                shoot.shotDelay = 3f;
                targetGround = false;
                shootY = 3f;
                shootCone = 15f;
                coolant = consumeCoolant(0.1f);
            }
        };

        ginquis = new ItemTurret("Ginquis") {
            {
                localizedName = "Ginquis";
                requirements(Category.turret, with(cophalast, 10));

                ammo(
                        Items.surgeAlloy, new RailBulletType() {
                            {
                                shootEffect = Fx.instShoot;
                                hitEffect = Fx.instHit;
                                pierceEffect = Fx.railHit;
                                smokeEffect = Fx.smokeCloud;
                                pointEffect = Fx.instTrail;
                                despawnEffect = Fx.instBomb;
                                pointEffectSpace = 20f;
                                damage = 1350;
                                buildingDamageMultiplier = 0.2f;
                                pierceDamageFactor = 1f;
                                length = 12f;
                                hitShake = 6f;
                                ammoMultiplier = 1f;
                            }
                        });

                drawer = ammoBarrelOutEffect;

                reload = 20;
                range = 1240;
                health = 250;
                inaccuracy = 2f;
                rotateSpeed = 10f;
                ammoUseEffect = Fx.casing1;
                size = 4;

                recoil = 0.5f;
                recoil = 2f;
                shoot = new ShootAlternate() {
                    {
                        spread = 4.7f;
                        shots = 1;
                        barrels = 1;
                    }
                };
                shoot.shots = 1;
                shoot.shotDelay = 3f;
                targetGround = false;
                shootY = 3f;
                shootCone = 15f;
                coolant = consumeCoolant(0.1f);
            }
        };

        ares = new ItemTurret("Ares") {
            {
                localizedName = "Ares";
                requirements(Category.turret, with(cophalast, 10));

                PartProgress partProgress = PartProgress.warmup;
                Color haloColor = Color.valueOf("d370d3");
                Color heatCol = Color.purple;
                float haloY = -15f, haloRotSpeed = 1.5f;

                PartProgress circleProgress = PartProgress.warmup.delay(0.9f);
                Color circleColor = haloColor;
                float circleY = 25f, circleRad = 11f,
                        circleRotSpeed = 3.5f, circleStroke = 1.6f;

                shootSound = Sounds.malignShoot;
                loopSound = Sounds.spellLoop;
                loopSoundVolume = 1.3f;

                ammo(cophalast, new FlakBulletType(8f, 70f) {
                    {
                        sprite = "missile";
                        lifetime = 45f;
                        width = 12f;
                        height = 22f;
                        hitSize = 7f;
                        shootEffect = Fx.shootSmokeSquareBig;
                        smokeEffect = Fx.shootSmokeDisperse;
                        hitColor = backColor = trailColor = lightningColor = circleColor;
                        frontColor = Color.white;
                        trailWidth = 3f;
                        trailLength = 12;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        buildingDamageMultiplier = 0.3f;

                        trailEffect = Fx.colorSpark;
                        trailRotation = true;
                        trailInterval = 3f;
                        lightning = 1;
                        lightningCone = 15f;
                        lightningLength = 20;
                        lightningLengthRand = 30;
                        lightningDamage = 20f;
                        homingPower = 0.17f;
                        homingDelay = 19f;
                        homingRange = 160f;
                        explodeRange = 160f;
                        explodeDelay = 0f;

                        flakInterval = 20f;
                        despawnShake = 3f;

                        fragBullet = new LaserBulletType(65f) {
                            {
                                colors = new Color[] { haloColor.cpy().a(0.4f),
                                        haloColor, Color.white };
                                buildingDamageMultiplier = 0.25f;
                                width = 19f;
                                hitEffect = Fx.hitLancer;
                                sideAngle = 175f;
                                sideWidth = 1f;
                                sideLength = 40f;
                                lifetime = 22f;
                                drawSize = 400f;
                                length = 180f;
                                pierceCap = 2;
                            }
                        };

                        fragSpread = fragRandomSpread = 0f;

                        splashDamage = 0f;
                        hitEffect = Fx.hitSquaresColor;
                        collidesGround = true;
                    }
                });

                drawer = new DrawTurret("reinforced-") {
                    {
                        parts.addAll(
                                // summoning circle
                                new ShapePart() {
                                    {
                                        progress = circleProgress;
                                        color = circleColor;
                                        circle = true;
                                        hollow = true;
                                        stroke = 0f;
                                        strokeTo = circleStroke;
                                        radius = circleRad;
                                        layer = Layer.effect;
                                        y = circleY;
                                    }
                                },

                                new ShapePart() {
                                    {
                                        progress = circleProgress;
                                        rotateSpeed = -circleRotSpeed;
                                        color = circleColor;
                                        sides = 4;
                                        hollow = true;
                                        stroke = 0f;
                                        y = circleY;
                                        strokeTo = circleStroke;
                                        radius = circleRad - 1f;
                                        layer = Layer.effect;
                                    }
                                });
                    }
                };

                velocityRnd = 0.15f;
                shoot = new ShootSummon(0f, 0f, circleRad, 48f);

                shootY = circleY - 5f;
                outlineColor = Pal.darkOutline;
                reload = 9f;
                range = 370;
                shootCone = 100f;
                scaledHealth = 370;
                rotateSpeed = 2f;
                recoil = 0.5f;
                recoilTime = 30f;
                shake = 3f;
            }
        };
    }
}