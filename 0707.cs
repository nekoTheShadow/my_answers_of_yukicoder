using System;
using System.Collections.Generic;
using System.Linq;

namespace _707
{
    class Program
    {
        static void _Main(string[] args)
        {
            var line = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            var h = line[0];
            var w = line[1];

            var blacks = new List<Tuple<int, int>>();
            for (int x = 0; x < h; x++)
            {
                var row = Console.ReadLine().Select(ch => ch - '0').ToList();
                for (int y = 0; y < w; y++)
                {
                    if (row[y] == 1)
                    {
                        blacks.Add(Tuple.Create(x + 1, y + 1));
                    }
                }
            }

            var positions = new List<Tuple<int, int>>();
            for (int x = 0; x <= h + 1; x++)
            {
                for (int y = 0; y <= w + 1; y++)
                {
                    if (x == 0 || x == h + 1 || y == 0 || y == w + 1)
                    {
                        positions.Add(Tuple.Create(x, y));
                    }
                }
            }

            var answer = double.MaxValue;
            foreach (var position in positions)
            {
                var sum = 0.0;
                foreach (var black in blacks)
                {
                    var x = Math.Pow((double)(position.Item1 - black.Item1), 2.0);
                    var y = Math.Pow((double)(position.Item2 - black.Item2), 2.0);
                    sum += Math.Sqrt(x + y);
                }

                answer = Math.Min(answer, sum);
            }

            Console.WriteLine(answer);
        }
    }
}
