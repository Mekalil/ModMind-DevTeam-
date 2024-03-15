package example;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import mindustry.type.*;
import arc.graphics.*;

public class ExampleJavaMod extends Mod{

    public ExampleJavaMod(){
    }

    @Override
    public void loadContent(){
        Log.info("Loading some example content.");
        // loading content. We content too less to in many files      
        // item category:
        Item cophalast = new Item("Cophalast", Color.valueOf("dee650")){{
            cost = 1f;
        }};

        Item trinaxide = new Item("Trinaxide", Color.valueOf("dee650")){{
            cost = 1f;
        }};

        Item monoglox = new Item("Monoglox", Color.valueOf("dee650")){{
            cost = 1f;
        }};

        Item polamenis = new Item("Polanemis", Color.valueOf("dee650")){{
            cost = 1f;
            flammability = 1f;
            explosiveness = 0.2f;
        }};

        Item xenathium = new Item("Xenathium", Color.valueOf("dee650")){{
            cost = 1f;
        }};

        Item hilimeni = new Item("Hilimeni", Color.valueOf("dee650")){{
            cost = 1f;
            flammability = 0.2f;
            explosiveness = 1f;
        }};

        Item hexademia = new Item("Hexademia", Color.valueOf("dee650")){{
            cost = 1f;
        }};

        // Synthetic materials

        Item kructrok = new Item("Kructrok", Color.valueOf("dee650")){{
            cost = 1f;
        }};

        Item nasmehro = new Item("Nasmehro", Color.valueOf("dee650")){{
            cost = 1f;
        }};

        Item flukemasd = new Item("Flukemasd fiber", Color.valueOf("dee650")){{
            cost = 1f;
        }};

        // End of material, start for liquid.
        
        Liquid medrali = new Liquid("Medrali", Color.valueOf("ffee00")){{
            // lol i did nothing
        }};

        Liquid poligen = new Liquid("Poligen", Color.valueOf("ffee00")){{
            gas = true;
        }};

        Liquid petragen = new Liquid("Petragen", Color.valueOf("ffee00")){{
            gas = true;
        }};

        // End of liquid, next one for drills - block

        

        

        

        
        
        
        
    }

}
