public class Note implements Comparable<Note> {
    public Note(long hitTime, int track, int length) {
        this.hitTime = hitTime;
        this.track = track;
        this.length = length;
    }

    ;

    private long hitTime;

    public int getLength() {
        return length;
    }

    private int length;

    public int getTrack() {
        return track;
    }

    private int track;

    public long getHitTime() {
        return hitTime;
    }

    public int compareTo(Note another) {
        return Long.compare(hitTime, another.hitTime);
    }

}
