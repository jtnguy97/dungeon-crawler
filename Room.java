public class Room{

private String description;
private String name;
private Room north;
private Room east;
private Room west;
private Room south;

//constructor
public Room(String name, String description){
this.name = name;
this.description = description;

}

public String toString(){
return String.format("\nCurrent location: [%s]\n%s\n\nChoose where to go next.\n%s", this.name, this.description, this.getExits());
}

public String getName(){
return this.name;
}

public String getDescription(){
return this.description;
}

public void setNorth(Room north){
this.north = north;
}


public void setEast(Room east){
this.east = east;
}


public void setWest(Room west){
this.west = west;
}


public void setSouth(Room south){
this.south = south;
}


public void setExits(Room n, Room e, Room w, Room s){
north = n;
east = e;
west = w;
south = s;
}

public Room getNorth(){
return this.north;
}

public Room getEast(){
return this.east;
}

public Room getWest(){
return this.west;
}


public Room getSouth(){
return this.south;
}


public String getExits(){
String n = "n: ";
String e = "e: ";
String w = "w: ";
String s = "s: ";
String noRoom = "";

if(north!=null){
	noRoom = noRoom + n + north.getName()+"\n";
}
if(east!=null){
	noRoom = noRoom + e + east.getName()+"\n";
}
if(west!=null){
	noRoom = noRoom + w + west.getName()+"\n";
}
if(south!=null){
	noRoom = noRoom + s + south.getName()+"\n";
}
return noRoom;

}










}