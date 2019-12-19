package salesforce;
import java.util.Scanner;
import java.util.*;


public class packageDependency {

    /**
     * Stores package names and dependencies
     */
    static class packages{

        String name;
        //Maintains a list of available packages
        ArrayList<packages> dependentList = new ArrayList<>();
        //Maintains a list of installed packages
        ArrayList<packages> belongsTo = new ArrayList<>();

        packages(String name){
            this.name = name;
        }

        //Add a dependency to the package
        public void addDependencies(packages depend){
            this.dependentList.add(depend);
        }

        //Add packages which require this
        public void addBelongsTo(packages belong){
            this.belongsTo.add(belong);
        }

        //Get all Dependencies
        public ArrayList getDependencies(){
            return this.dependentList;
        }

        //Get all belongsTp
        public ArrayList getBelongsTo(){
            return this.belongsTo;
        }

        //Get Package name
        public String getPackageName(){
            return this.name;
        }

        //Returns boolen if the package is one of the dependencies
        public boolean hasDependent(packages depending){
            return this.dependentList.contains(depending);
        }

        //Returns boolean if the packege is a dependency for another package
        public boolean doesBelongTo(packages pack){
            return this.belongsTo.contains(pack);
        }
    }

    //Package with dependencies
    public static HashMap<String, packages> availablePackages = new HashMap<String,packages>();
    //Installed Packages
    public static ArrayList<String> installedPackages = new ArrayList<String>();

    static void doIt(String[] input) {
        for (String inputLine: input) {
            //Echo the command
            System.out.println(inputLine);

            //Separate the command and packages
            String words[] = inputLine.split("\\s+");

            //Execute the command
            switch(words[0]){
                case "INSTALL":
                    install(words[1]);
                    break;
                case "DEPEND":
                    depend(words);
                    break;
                case "REMOVE":
                    remove(words[1]);
                    break;
                case "LIST":
                    listPackages();
                    break;
                case "END":
                default:
                    break;
            }
        }
    }

    /**
     * Create Package and
     * Add Dependencies
     * @param words
     */
    static void depend(String[] words){

            packages newPackage;

            //If package not in availabe list add the package
            if(!availablePackages.containsKey(words[1])){
                newPackage = new packages(words[1]);
            }else{
                newPackage = availablePackages.get(words[1]);
            }

            //Add Dependency
            for(int i=2; i< words.length; i++){

                packages dependentPackage;

                if(!availablePackages.containsKey(words[i])){
                    //If package does not already exist
                    dependentPackage = new packages(words[i]);

                    newPackage.addDependencies(dependentPackage);
                    dependentPackage.addBelongsTo(newPackage);

                    //Update available Packages with updated package List
                    availablePackages.put(newPackage.getPackageName(), newPackage);
                    availablePackages.put(words[i], dependentPackage);
                }else{
                    //If package already exists
                    dependentPackage = availablePackages.get(words[i]);

                    //Check for circular dependency
                    if(isCircular(dependentPackage, newPackage)){
                        System.out.println(words[i]+" depends on "+words[1]+", ignoring command");
                    }else{
                        dependentPackage.addBelongsTo(newPackage);
                        newPackage.addDependencies(dependentPackage);

                        //Update available Packages with updated package List
                        availablePackages.put(newPackage.getPackageName(), newPackage);
                        availablePackages.put(words[i], dependentPackage);
                    }
                }
            }
    }

    /**
     * Returns true for circular dependency
     * @param dependent
     * @param master
     * @return
     */
    public static boolean isCircular(packages dependent, packages master){
        if(master.doesBelongTo(dependent)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Install all packages
     * @param word
     */
    public static void install(String word){

        //Check to see if the package is already installed
        if(installedPackages.contains(word)){
            System.out.println(word + " is already installed");
        }else{

            //Check to see if the package is in available list
            if(!availablePackages.containsKey(word)){
                //If not available add to the available list and then install
                packages newPackage = new packages(word);
                availablePackages.put(word, newPackage);
                installedPackages.add(word);
                System.out.println("Installing "+word);
            }else{
                //Install the package and all the dependecies
                installedPackages.add(word);
                System.out.println("Installing "+word);
                //Install all dependencies
                packages givenPackage = availablePackages.get(word);
                ArrayList<packages> dependencies = givenPackage.getDependencies();
                for(packages pak: dependencies){
                    if(!installedPackages.contains(pak.getPackageName())){
                        install(pak.getPackageName());
                    }
                }
            }
        }
    }

    /**
     * Remove the package
     * @param word - Package to me removed
     */
    public static void remove(String word){

            //Check to see if the package is installed
            if(!installedPackages.contains(word)){
                System.out.println(word+" is not installed");
            }else{
                packages remove = availablePackages.get(word);
                //Check to see if the package being removed belongsTo any of the packages that have been installed
                if(!cannotRemove(remove)){
                    System.out.println("Removing "+ word);
                    installedPackages.remove(word);
                    //Remove all the dependents if possible
                    removeDependents(word);
                }else{
                    System.out.println("Cannot remove "+word);

                }
            }

    }

    /**
     * Check if a package is not a dependency to an already installed package
     * true if yes , false if no
     * @param pak
     * @return
     */
    public static boolean cannotRemove(packages pak){
        boolean flag = false;

        ArrayList<packages> belongsToList = pak.getBelongsTo();
        for(packages p: belongsToList) {
            if(installedPackages.contains(p.getPackageName())){
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    /**
     * Remove Dependents
     * @param word
     */
    public static void removeDependents(String word){

        packages mainPackage = availablePackages.get(word);
        //Get all dependents
        ArrayList<packages> dependents = mainPackage.getDependencies();
        //Loop and remove is possible
        for(packages pak:dependents){
            //If it can be removed
            if(!cannotRemove(pak)){
                System.out.println("Removing "+pak.getPackageName());
                installedPackages.remove(pak.getPackageName());
            }
        }
    }

    /**
     * Print the list of packages installed
     */
    static void listPackages(){
        for(String pak:installedPackages){
            System.out.println(pak);
        }
    }


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int _input_size = 0;
        //Size of input
        _input_size = Integer.parseInt(in.nextLine().trim());
        //Setting Input Size of Strings
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        doIt(_input);

    }
}
