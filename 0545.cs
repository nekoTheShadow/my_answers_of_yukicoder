using System;
using System.Collections.Generic;
using System.Linq;

namespace _545
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var inputs = Enumerable.Range(0, n).Select(_ =>
            {
                var line = Console.ReadLine().Split().Select(long.Parse).ToList();
                return Tuple.Create(line[0], line[1]);
            }).ToList();

            // 入力の前半分と後半分で全列挙を行う。
            var len = inputs.Count;
            var diffs1 = CreateDiffs(inputs, 0, len / 2);
            var diffs2 = CreateDiffs(inputs, len / 2, len);

            long best = long.MaxValue;
            int len2 = diffs2.Count;
            foreach (long diff1 in diffs1)
            {
                // diffs2のうち、-diff1に最も近いものを探す(2分探索)
                int low = 0, high = len2 - 1;
                while (low < high)
                {
                    int mid = (low + high) / 2;
                    if (diffs2[mid] < -diff1)
                    {
                        low = mid + 1;
                    }
                    else
                    {
                        high = mid;
                    }
                }

                // low-1, low, low+1から答えを探す。
                for (int idx = low - 1; idx < low + 2; idx++)
                {
                    if (0 <= idx && idx < len2)
                    {
                        long diff2 = diffs2[idx];
                        best = Math.Min(best, Math.Abs(diff1 + diff2));
                    }
                    
                }
            }

            Console.WriteLine(best);
        }

        static List<long> CreateDiffs(List<Tuple<long, long>> inputs, int start, int end)
        {
            var diffs = new HashSet<long>() { 0 };
            for (int i = start; i < end; i++)
            {
                var input = inputs[i];
                var nexts = new HashSet<long>();
                foreach (var diff in diffs)
                {
                    nexts.Add(diff + input.Item1);
                    nexts.Add(diff - input.Item2);
                }
                diffs = nexts;
            }

            var answer = diffs.ToList();
            answer.Sort();
            return answer;
        }

    }
}
