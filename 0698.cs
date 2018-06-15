using System;
using System.Collections.Generic;
using System.Linq;

namespace _698
{
    class Program
    {
        static void Main(String[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var scores = Console.ReadLine().Split().Select(int.Parse).ToList();

            var ans = new Program(scores).Solve();
            Console.WriteLine(ans);
        }
        

        private List<int> scores;

        Program(List<int> scores)
        {
            this.scores = scores;
        }

        int Solve()
        {
            return this.Dp(0, 0);
        }

        int Dp(int x, int bit)
        {
            if (scores.Count <= x)
            {
                return 0;
            }

            if ((bit & (1 << x)) != 0)
            {
                return Dp(x + 1, bit);
            }

            int ans = 0;
            for (int y = x + 1; y < scores.Count; y++)
            {
                if ((bit & (1 << y)) == 0)
                {
                    ans = Math.Max(ans, (scores[x] ^ scores[y]) + this.Dp(x + 1, bit | (1 << y)));
                }
            }
            return ans;
        }
    }
}