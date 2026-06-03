package dependencies;

import java.util.TreeSet;

public abstract class Spark implements Comparable<Spark>{
    public static TreeSet<Spark> sparks = new TreeSet<Spark>();
    protected final int canID;

    public Spark(int canID) throws Exception{
        this.canID = canID;

        for (Spark spark : sparks) {
            if (spark.getCanID() == this.canID) {
                throw new Exception("Duplicate canID");
            }
        }

        sparks.add(this);
    }

    private int getCanID() {
        return this.canID;
    }

    public abstract String periodic();

    @Override
    public int compareTo(Spark other) {
        return this.canID - other.getCanID();
    }

    

}
