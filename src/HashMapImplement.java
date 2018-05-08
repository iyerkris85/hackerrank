import java.util.Map;

class Key{

    String key;
    Key(String key)
    {
        this.key = key;
    }

    @Override
    public int hashCode()
    {
         if((int)key.charAt(0) != 0){
             return (int)key.charAt(0);
         }else{
             return 1;
         }
    }

    @Override
    public boolean equals(Object obj)
    {
        return key.equals(((Key)obj).key);
    }

}

class Node{

    int hash;
    Key key;
    int value;
    Node nextnode;

    Node(int hash, Key key, int value, Node node){
        this.hash = hash;
        this.key  = key;
        this.value = value;
        this.nextnode = node;
    }

}

class HashMapNew {

    static int capacity = 16;
    Node[] mapnodes = new Node[16];

    //Calculate Index
    int getIndex(int hashcode){

        int index = hashcode & (capacity-1);
        return index;
    }

    //Insert to the HashMap
    void put(Key key, int value){

        int hashCode = key.hashCode();
        int index = getIndex(hashCode);
        System.out.println(index+" "+key.key+" "+value);
        Node newNode = new Node(hashCode,key,value,null);

        try{
            //Check if a node already exists in the calculated index
            if(mapnodes[index] == null){
                //If no node exists
                mapnodes[index] = newNode;
            }else{
                Node existingNode = mapnodes[index];
                //while existing node is the last node and the key is not equal to given key keep traversing
                while(existingNode.nextnode != null && !(existingNode.key.equals(key))){
                    existingNode = existingNode.nextnode;
                }
                //If the same key is being used , replace the value
                if((existingNode.key.equals(key))){
                    existingNode.value = value;
                }else{
                    existingNode.nextnode = newNode;
                }
            }
        }catch(Exception e){

        }

    }

    //Get value of a Key
    int get(Key key){

        int hashCode = key.hashCode();
        int index = getIndex(hashCode);

        Node initialNode = mapnodes[index];

        //Traverse until you find the key
        while(!(initialNode.key.equals(key)) && (initialNode.nextnode != null)){
            initialNode = initialNode.nextnode;
        }

        //If the key is equivalent return value else return exception
        if(initialNode.key.equals(key)){
          return initialNode.value;
        }else{
            throw new RuntimeException();
        }
    }
}

class HashMapImplement{

    public static void main(String args[]){

        HashMapNew map = new HashMapNew();
        map.put(new Key("vishal"), 20);
        map.put(new Key("sachin"), 30);
        map.put(new Key("vaibhav"), 40);

        System.out.println();
        System.out.println("Value for key vishal: " +
                map.get(new Key("vishal")));
        System.out.println("Value for key sachin: " +
                map.get(new Key("sachin")));
        System.out.println("Value for key vaibhav: " +
                map.get(new Key("vaibhav")));

        map.put(new Key("vaibhav"), 90);

        System.out.println("Value for key vaibhav: " +
                map.get(new Key("vaibhav")));
        System.out.println("Value for key vishal: " +
                map.get(new Key("vishal")));
    }
}
