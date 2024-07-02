package neko.content;

import static neko.content.NekoItemsAndLiquids.cophalast;
import static neko.content.NekoItemsAndLiquids.hexademia;
import static neko.content.NekoItemsAndLiquids.hilimeni;
import static neko.content.NekoItemsAndLiquids.polamenis;
import static neko.content.NekoItemsAndLiquids.trinaxide;
import static neko.content.NekoItemsAndLiquids.xenathium;

import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.environment.StaticWall;

public class NekoEnviromentBlocks {
	public static Block cophalastOre, cophalastWallOre, trinaxideOre, trinaxideWallOre,
			polamenisOre, xenathiumOre, xenathiumWallOre, hilimeniCrystal,
			hexademiaOre, hexademiaWallOre;

	public static void load() {
		cophalastOre = new OreBlock(cophalast);
		cophalastWallOre = new OreBlock("CophalastW", cophalast) {
			{
				wallOre = true;
			}
		};

		trinaxideOre = new OreBlock(trinaxide);
		trinaxideWallOre = new OreBlock("TrinaxideW", trinaxide) {
			{
				wallOre = true;
			}
		};

		polamenisOre = new OreBlock(polamenis);
		xenathiumWallOre = new OreBlock(xenathium);
		xenathiumWallOre = new OreBlock("XenathiumW", xenathium) {
			{
				wallOre = true;
			}
		};

		hilimeniCrystal = new StaticWall("Hilimeni Crystal") {
			{
				itemDrop = hilimeni;
				variants = 3;
				localizedName = "Hilimeni Crystal";
			}
		};

		hexademiaOre = new OreBlock(hexademia);
		hexademiaWallOre = new OreBlock("HexademiaW", hexademia) {
			{
				wallOre = true;
			}
		};

		// load environmental block& floor = for loop wtf shit
		for (int i = 1; i < 4; i++) {
			int x = i;
			new Floor("Floor" + i) {
				{
					localizedName = "Floor " + x;
					variants = 3;
				}
			};

			new StaticWall("Wall" + i) {
				{
					localizedName = "Wall " + x;
					variants = 3;
				}
			};
		}
	}
}