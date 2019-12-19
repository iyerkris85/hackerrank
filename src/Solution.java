import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the function below.
     */

    static void doIt(String[] input) {
        for (String inputLine: input) {

           //Echo the command
           System.out.println(inputLine);
           //Separate the command and packages
           String words[] = inputLine.split("\\s+");

           //For each Command perfom the function and print the output
           switch(words[0]){
               case "DEPEND":
                   depend(words);
                   break;
               case "INSTALL":
                   install(words);
                   break;
               case "REMOVE":
                   removePackage(words);
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
     * Create packages and dependencies
     * @param words
     */
    public static void depend(String[] words){

        //If Package is not in dictionary Add it else do nothing
        if(!availablePackages.containsKey(words[1])){
            packages newPackage = new packages(words[1]);
            availablePackages.put(words[1], newPackage);
        }

        //Get the added package
        packages newPackage = availablePackages.get(words[1]);

        //Add Dependencies
        for(int i=2; i< words.length; i++) {

            //If dependent package is not in dictionary add it and add it as dependency to master
            if(!availablePackages.containsKey(words[i])){
                //Adding to dictionary
                packages newDependentPackage = new packages(words[i]);
                newDependentPackage.addBelongsTo(newPackage);
                availablePackages.put(words[i], newDependentPackage);
                //Update the package
                newPackage.addDependencies(newDependentPackage);
                //Update new Package
                availablePackages.put(words[1], newPackage);
            }else{
                //If Package is available . Check for circular dependency
                packages newDependentPackage = availablePackages.get(words[i]);
                if(newDependentPackage.hasDependent(newPackage)){
                    //Print the Circular Error
                    System.out.println(newDependentPackage.getPackageName()+" depends on "+ newPackage.getPackageName()+" , ignoring command");
                }else{
                    newDependentPackage.addBelongsTo(newPackage);
                    //Update the package dependency
                    newPackage.addDependencies(newDependentPackage);
                    //Update new Package and dependentPackage
                    availablePackages.put(words[1], newPackage);
                    availablePackages.put(words[i],newDependentPackage);
                }

            }
        }

    }

    /**
     * Install a package
     * @param words
     */
    public static void install(String[] words){

        //If package is not available then add to all available and install dictionary
        if(!availablePackages.containsKey(words[1])){

            packages newpackage = new packages(words[1]);
            availablePackages.put(words[1],newpackage);
            installedPackages.put(words[1], newpackage);
            System.out.println("Installing "+words[1]);
        }else{

            packages install = availablePackages.get(words[1]);

            //If not installed install the package
            if(!installedPackages.containsKey(install.getPackageName())){
                installedPackages.put(install.getPackageName(),install);
                System.out.println("Installing "+words[1]);
            }

            //Get all the dependencies
            ArrayList<packages> dependPackages = install.getDependencies();
            //Install all the dependencies
            for (packages dep:
                    dependPackages) {
                if(!installedPackages.containsKey(dep.getPackageName())){
                    installedPackages.put(dep.getPackageName(),dep);
                    System.out.println("Installing "+dep.getPackageName());
                }
                if(!dependentModules.containsKey(dep.getPackageName())){
                    dependentModules.put(dep.getPackageName(),dep);
                }
            }
        }

    }

    /**
     * Remove a package
     * @param words
     */
    public static void removePackage(String[] words){

        packages remove = availablePackages.get(words[1]);
        //Check if the package is installed
        if(!installedPackages.containsKey(remove.getPackageName())){
            System.out.println( words[1]+" is not installed");
        }else{
            //If installed check dependency
            if(dependentModules.containsKey(remove.getPackageName())){
                System.out.println(words[1]+" is still needed");
            }else{
                //Remove from the list of installed packaged
                installedPackages.remove(remove.getPackageName());
                System.out.println("Removing "+words[1]);
                //Remove any dependency that is not in the dependency list

                //List of all dependencies
                ArrayList<packages> dependents = remove.getDependencies();

                for(packages dep:dependents){
                    //Check if any of the installed components has the package as dependency
                    boolean flag = true;
                    for(packages installed:installedPackages.values()){
                        if(installed.hasDependent(dep)){
                            flag = false;
                        }
                    }
                    if(flag){
                        installedPackages.remove(dep.getPackageName());
                        dependentModules.remove(dep.getPackageName());
                        System.out.println("Removing "+ dep.getPackageName());
                    }
                }

            }
        }

    }

    /**
     * Print all the installed packages
     */
    public static void listPackages(){
        ArrayList<String> keys = new ArrayList<String>(installedPackages.keySet());
        for(int i=keys.size()-1; i>=0;i--){
            System.out.println(installedPackages.get(keys.get(i)).getPackageName());
        }
//       for(packages pak: installedPackages.values()){
//           System.out.println(pak.getPackageName());
//       }
    }

    /**
     * Stores package names and dependencies
     */
    static class packages{

        String name;
        ArrayList<packages> dependency = new ArrayList<packages>();
        ArrayList<packages> belongsTo = new ArrayList<packages>();

        packages(String name){
            this.name = name;
        }

        //Add a dependency to the package
        public void addDependencies(packages depend){
            this.dependency.add(depend);
        }

        //Add packages which require this
        public void addBelongsTo(packages belong){
            this.belongsTo.add(belong);
        }

        //Get all Dependencies
        public ArrayList getDependencies(){
            return dependency;
        }

        //Get Package name
        public String getPackageName(){
            return this.name;
        }

        //Returns boolen if the package is one of the dependencies
        public boolean hasDependent(packages depending){
            return this.dependency.contains(depending);
        }

        //Returns boolean if the packege is a dependency for another package
        public boolean doesBelongTo(packages pack){
            return this.belongsTo.contains(pack);
        }
    }

    //Package with dependencies
    public static HashMap<String, packages> availablePackages = new HashMap<String,packages>();
    //Installed Packages
    public static HashMap<String, packages> installedPackages = new HashMap<String,packages>();
    //Dependent Modules
    public static HashMap<String, packages> dependentModules  = new HashMap<String,packages>();

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