/**
 *
 * CSE 240 Assignment01
 * Program to store and manage guest information
 * @author Nikita Bahl
 */
package cse240assignment01;

public class Guest {
    String firstName;
    String lastName;
    
    //constructor to initialize firstName and lastName
    public Guest()
    {
        firstName = "???";
        lastName = "???";
    }
    
    //method to split the guest name by the '/' character
    public Guest(String guestInfo)
    {
        String[] words = guestInfo.split("/");//splits the string based on "/"
         
        this.firstName = words[0];
        this.lastName = words[1];
    }
    
    //method that returns the lastName of the guest 
    public String getLastName()
    {
        return this.lastName;
    }
    
    //method that returns the firstName of the guest
    public String getFirstName()
    {
        return this.firstName;
    }
    
    // method to return the initials of the guest in the form such as D.R.
    @Override
    public String toString()
    {
        return this.firstName.charAt(0)+ "."+this.lastName.charAt(0)+ ".";
    }
}
