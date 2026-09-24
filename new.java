public static ArrayList<TotalDonation> aggregateDonations(ArrayList<Donation> donations) {
    ArrayList<TotalDonation> totals = new ArrayList<>();

    if (donations == null) {
        return totals;
    }

    for (Donation donation : donations) {
        if (donation == null ||
            donation.getUser() == null ||
            donation.getAmount() < 0) {
            return new ArrayList<>();
        }

        boolean found = false;

        // Look for this person in the totals we already have.
        for (TotalDonation total : totals) {
            if (total.getUser().equals(donation.getUser())) {
                total.setAmount(total.getAmount() + donation.getAmount());
                total.setCount(total.getCount() + 1);
                found = true;
                break;
            }
        }

        // If we did not find them, add their first donation.
        if (!found) {
            totals.add(new TotalDonation(donation.getUser(), donation.getAmount(), 1));
        }
    }

    return totals;
}