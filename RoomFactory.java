/**
 * Write a description of class RoomFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoomFactory{
    public Room createRoomSetupAndGetStartRoom() {
        Room entranceHall, oakHall, parlour, spareRoom, smokingRoom, eastHall,
        kitchen, wineCellar, coldCellar, pantry, atrium, diningRoom, storage,
        westHall, studyRoom, backRoom, guestRoom, bedRoom;
        //create items
        Item stick, cat, hat,pipe,paper,bagpack,sleepingBag,cutlery,lembas;
        stick = new Item("Stick", "a Stick", 1);
        cat = new Item("Cat"," a grumpy looking cat", 2);
        hat = new Item("Hat","a shiny new Hat",1);
        pipe = new Item("Pipe","Bilbo Baggins' Pipe", 2);
        paper = new Item("Newspaper","The Newspaper from yesterday",1);
        bagpack = new Item("Bagpack","A Bagpack ready to be filled",3);
        sleepingBag = new Item("Sleeping Bag","An improvised sleeping bag",3);
        cutlery = new Item("Cutlery","A fork, a knife and a spork",1);
        lembas = new Item("Lembas Bread","A fresh loaf of juicy bread",1);
        
        // create the rooms
        entranceHall = new Room("in the entrance hall", "You see coat hooks at the side", cat);
        entranceHall.addItemToRoom(stick);
        
        oakHall = new Room("in the oak hall", "That oak though");
        oakHall.addItemToRoom(hat);
        
        parlour = new Room("in the parlour", "A nice fire is burning in the stove");
        parlour.addItemToRoom(paper);
        
        spareRoom = new Room("in the spare room", "Nothing to do here");
        
        smokingRoom = new Room("in the smoking room", "A funny smell is in the room, Bilbo's pipe is still burning");
        smokingRoom.addItemToRoom(pipe);
        
        eastHall = new Room("in the east hall", "A lot of stuff lying arround");
        
        kitchen = new Room("in the kitchen", "Tasty food ready to be made");
        kitchen.addItemToRoom(cutlery);
        kitchen.addItemToRoom(lembas);
        
        wineCellar = new Room("in the wine cellar", "Best wine in the shire");
        wineCellar.addItemToRoom(bagpack);
        
        coldCellar = new Room("in the cold cellar", "You see a few rats running away");
        
        pantry = new Room ("in the pantry", "The smell of a fresh mince pie reaches your nostrils");
        
        atrium = new Room ("in the atrium", "The lights are shining bright");
        atrium.addItemToRoom(sleepingBag);
        
        diningRoom = new Room ("in the dining room", "Cutlery and jugs with beer are set on the big dinner table");
        
        storage = new Room("in the storage", "Lots of stuff lying arround here, do i smell weed again?");
        
        westHall= new Room("in the west hall", "..");
        
        studyRoom = new Room("in the study room", "The room is filled with books, maps and drafts");
        
        backRoom = new Room("in the back room", "..");
        
        guestRoom = new Room("in the guest room", "A few beds for guest");
        
        bedRoom = new Room("in the bed room", "Bilbo's privacy space");
      
        entranceHall.setExit("west", parlour);
        entranceHall.setExit("north", oakHall);

        oakHall.setExit("east", spareRoom);
        oakHall.setExit("south", entranceHall);
        oakHall.setExit("north", smokingRoom);
        oakHall.setExit("west", eastHall);

        parlour.setExit("east", entranceHall);
        parlour.setExit("north", eastHall);
        parlour.setExit("west", kitchen);

        spareRoom.setExit("west", oakHall);
        smokingRoom.setExit("west", pantry);
        smokingRoom.setExit("south", oakHall);

        eastHall.setExit("south", parlour);
        eastHall.setExit("east", oakHall);
        eastHall.setExit("west", atrium);
        eastHall.setExit("south-west", kitchen);

        kitchen.setExit("east", parlour);
        kitchen.setExit("west", diningRoom);
        kitchen.setExit("north", eastHall);

        pantry.setExit("north-east", coldCellar);
        pantry.setExit("north-west", wineCellar);
        pantry.setExit("south", atrium);
        pantry.setExit("west", storage);
        pantry.setExit("east", smokingRoom);

        atrium.setExit("north", pantry);
        atrium.setExit("south", diningRoom);
        atrium.setExit("west", westHall);
        atrium.setExit("east", eastHall);
        atrium.setExit("south-west", studyRoom);

        coldCellar.setExit("south", pantry);

        wineCellar.setExit("south-west", storage);
        wineCellar.setExit("west", backRoom);

        diningRoom.setExit("east", kitchen);
        diningRoom.setExit("north", atrium);

        storage.setExit("south", westHall);
        storage.setExit("north-west", backRoom);
        storage.setExit("north-east", wineCellar);
        storage.setExit("west", pantry);

        studyRoom.setExit("west", bedRoom);
        studyRoom.setExit("north", atrium);

        backRoom.setExit("east", wineCellar);
        backRoom.setExit("east-south", storage);

        westHall.setExit("north-east", storage);
        westHall.setExit("north-west", backRoom);
        westHall.setExit("south-west", guestRoom);
        westHall.setExit("west", atrium);

        bedRoom.setExit("east", studyRoom);
        
        guestRoom.setExit("north-east", westHall);

        return entranceHall;  // start game outside
    }
}