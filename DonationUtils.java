import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DonationUtils {

    public static ArrayList<TotalDonation> aggregateDonations(ArrayList<Donation> donations) {
        
        
         ArrayList<TotalDonation> totalAmt = new ArrayList<>();

        boolean valid = checkValid(donations);

        if (valid == false) {
            return totalAmt;
        }

        ArrayList<String> users = findUniqueUser(donations);

        for (int i = 0; i < users.size(); i++) {

            String currentUser = users.get(i);

            TotalDonation total = addTotalD(currentUser, donations);

            totalAmt.add(total);
        }

        return totalAmt;
    }


    private static boolean checkValid(ArrayList<Donation> donations) {

        if (donations == null) {
            return false;
        }

        for (int i = 0; i < donations.size(); i++) {

            Donation donation = donations.get(i);

            boolean donationMissing = donation == null;

            if (donationMissing == true) {
                return false;
            }

            String user = donation.getUser();
            double amount = donation.getAmount();

            boolean userMissing = user == null;
            boolean amountNegative = amount < 0;

            if (userMissing == true || amountNegative == true) {
                return false;
            }
        }

        return true;
    }


    private static ArrayList<String> findUniqueUser(ArrayList<Donation> donations) {

        ArrayList<String> users = new ArrayList<>();

        for (int i = 0; i < donations.size(); i++) {

            Donation donation = donations.get(i);
            String user = donation.getUser();

            boolean userAlreadyAdded = users.contains(user);

            if (userAlreadyAdded == false) {
                users.add(user);
            }
        }

        return users;
    }


    private static TotalDonation addTotalD(
            String currentUser,
            ArrayList<Donation> donations) {

        double totalAmount = 0;
        int donationCount = 0;

        for (int i = 0; i < donations.size(); i++) {

            Donation donation = donations.get(i);

            String user = donation.getUser();
            double amount = donation.getAmount();

            boolean sameUser = user.equals(currentUser);

            if (sameUser == true) {
                totalAmount = totalAmount + amount;
                donationCount = donationCount + 1;
            }
        }

        TotalDonation total = new TotalDonation(currentUser, totalAmount, donationCount);

        return total;
    
    }


//testing stuff!
public static void main(String[] args) {

     ArrayList<Donation> spongebobPatrickSquidwardDonations = new ArrayList<>();

    spongebobPatrickSquidwardDonations.add(new Donation("Spongebob", 100));
    spongebobPatrickSquidwardDonations.add(new Donation("Patrick", 50));
    spongebobPatrickSquidwardDonations.add(new Donation("Squidward", 1));
    spongebobPatrickSquidwardDonations.add(new Donation("Spongebob", 25));

    ArrayList<TotalDonation> totalAmt =
            aggregateDonations(spongebobPatrickSquidwardDonations);

    System.out.println(totalAmt.get(0).getUser());
    System.out.println(totalAmt.get(0).getAmount());
    System.out.println(totalAmt.get(0).getCount());

    System.out.println(totalAmt.get(1).getUser());
    System.out.println(totalAmt.get(1).getAmount());
    System.out.println(totalAmt.get(1).getCount());

    System.out.println(totalAmt.get(2).getUser());
    System.out.println(totalAmt.get(2).getAmount());
    System.out.println(totalAmt.get(2).getCount());


    System.out.println(aggregateDonations(null).size());


    ArrayList<Donation> nullDonationTest = new ArrayList<>();
    nullDonationTest.add(null);

    System.out.println(aggregateDonations(nullDonationTest).size());


    ArrayList<Donation> patrickNullUserTest = new ArrayList<>();
    patrickNullUserTest.add(new Donation(null, 50));

    System.out.println(aggregateDonations(patrickNullUserTest).size());


    ArrayList<Donation> squidwardNegativeAmountTest = new ArrayList<>();
    squidwardNegativeAmountTest.add(new Donation("Squidward", -1));

    System.out.println(aggregateDonations(squidwardNegativeAmountTest).size());
}
}




