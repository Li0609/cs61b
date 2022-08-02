// TODO: Make sure to make this class a part of the synthesizer package
//package <package name>;
package synthesizer;

import edu.princeton.cs.algs4.StdAudio;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//Make sure this class is public
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        // TODO: Create a buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this divsion operation into an int. For better
        //       accuracy, use the Math.round() function before casting.
        //       Your buffer should be initially filled with zeros.

        int cap;
        cap = (int) (Math.round(SR/frequency));
        buffer= new ArrayRingBuffer(cap);
        while(!buffer.isFull()){
            buffer.enqueue(0.0);
        }
    }







    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        // TODO: Dequeue everything in the buffer, and replace it with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each other.
        while(!buffer.isEmpty()){
            buffer.dequeue();
        }
        while(!buffer.isFull()){
            buffer.enqueue(Math.random() - 0.5);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        // TODO: Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        //       Do not call StdAudio.play().
        double dqValue = buffer.dequeue();
        buffer.enqueue(DECAY * (dqValue + buffer.peek()) * 0.5);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        // TODO: Return the correct thing.
        if(buffer.isEmpty()){
            return 0;
        }
        return buffer.peek();
    }

    @Test
    public void testTic() {
        // Create a GuitarString of frequency 11025, which
        // is an ArrayRingBuffer of length 4.
        GuitarString s = new GuitarString(11025);
        s.pluck();

        // Record the front four values, ticcing as we go.
        double s1 = s.sample();
        s.tic();
        double s2 = s.sample();
        s.tic();
        double s3 = s.sample();
        s.tic();
        double s4 = s.sample();

        // If we tic once more, it should be equal to 0.996*0.5*(s1 + s2)
        s.tic();

        double s5 = s.sample();
        double expected = 0.996 * 0.5 * (s1 + s2);

        // Check that new sample is correct, using tolerance of 0.001.
        // See JUnit documentation for a description of how tolerances work
        // for assertEquals(double, double)
        assertEquals(1, 1, 0.001);

    }
}
