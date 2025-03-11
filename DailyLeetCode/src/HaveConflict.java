public class HaveConflict {
    public boolean haveConflict(String[] event1, String[] event2) {
        int evStart=event1[0].compareTo(event2[1]);
        int evEnd=event1[1].compareTo(event2[0]);

        return evStart<=0 && evEnd>=0 ?true:false;
    }
}
