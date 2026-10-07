import java.util.ArrayList;
import java.util.Iterator;

/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version 7.0
 */
public class Club
{
    private ArrayList<Membership> members;

    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        members = new ArrayList<>(); // question 1
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        members.add(member); // question 3
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return members.size(); // question 2
    }

    /**
     * Determine the number of members who joined in the
     * given month.
     * @param month The month we are interested in.
     * @return The number of members who joined in that month.
     */
    public int joinedInMonth (int month) // question 4
    {
        int count = 0;
        if (0 < month && month <= 12) {
            for (Membership m : members) {
                if (m.getMonth() == month){
                    count++;
                }
            }
        } else {
            System.out.println("Accepted month values are between 1 and 12.");
            return 0;
        }
        return count;
    }
    
    /**
     * Remove from the club's collection all members who
     * joined in the given month, and return them stored
     * in a separate collection object.
     * @param month The month of the membership.
     * @param year The year of the membership.
     * @return The members who joined in the given month and year.
     */
    public ArrayList<Membership> purge(int month, int year) // question 5
    {
        ArrayList<Membership> purgeList = new ArrayList<>();
        if (0 < month && month <= 12) {
            for (Membership m : members) {
                if (m.getMonth() == month && m.getYear() == year) {
                    purgeList.add(m);
                }
            }
            members.removeAll(purgeList);
            return purgeList;
        } else {
            System.out.println("Accepted month values are between 1 and 12.");
            return null;
        }        
    }
    
    /**
     * Remove from the club's collection all members who
     * joined in the given month, and return them stored
     * in a separate collection object USING ITERATORS.
     * @param month The month of the membership.
     * @param year The year of the membership.
     * @return The members who joined in the given month and year.
     */
    public ArrayList<Membership> purge2(int month, int year) // question 5
    {
        ArrayList<Membership> purgeList = new ArrayList<>();
        if (0 < month && month <= 12) {
            Iterator<Membership> it = members.iterator();
            while (it.hasNext()) {
                Membership m = it.next();
                if (m.getMonth() == month && m.getYear() == year) {
                    purgeList.add(m);
                    it.remove();
                }
            }
        } else {
            System.out.println("Accepted month values are between 1 and 12.");
            return null;
        }
        return purgeList;
    }
}