package neko.content;

public class NekoContentLoader {
    public static void load() {
        NekoItemsAndLiquids.load();
        NekoBlocks.load();
        NekoDefensive.load();
        NekoEnviromentBlocks.load();
        NekoUnit.load();
    }
}