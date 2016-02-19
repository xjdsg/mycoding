import java.io.*;
import java.util.*;
/**
 * Created by jiaoxu on 2/17/2016.
 */
public class ActivitiesArrange {
    public static class SegLine
    {
        public int start;
        public int end;

        SegLine(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        List<SegLine> segLines = new ArrayList<SegLine>();
        int start, end;
        for(int i = 0; i < n; i++)
        {
            start = in.nextInt();
            end = in.nextInt();
            segLines.add(new SegLine(start, end));
        }

        Collections.sort(segLines, new Comparator<SegLine>() {
            @Override
            public int compare(final SegLine lhs, SegLine rhs) {
                if(lhs.end == rhs.end)
                {
                    return lhs.start - rhs.start;
                }
                return lhs.end - rhs.end;
            }
        });

        long count = 0;
        int last = Integer.MIN_VALUE;
        for(SegLine line: segLines)
        {
            if(line.start >= last)
            {
                count++;
                last = line.end;
            }
        }
        out.println(count);
        out.flush();
    }
}
