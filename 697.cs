using System;
using System.Collections.Generic;
using System.Linq;

namespace _697
{
    class Program
    {
        static void Main(string[] args)
        {
            var tokens = Console.ReadLine().Split().Select(int.Parse).ToList();
            var h = tokens[0];
            var w = tokens[1];

            var field = new List<List<int>>();
            for (int i = 0; i < h; i++)
            {
                var row = Console.ReadLine().Split().Select(int.Parse).ToList();
                field.Add(row);
            }

            int counter = 0;
            for (int x = 0; x < h; x++)
            {
                for (int y = 0; y < w; y++)
                {
                    if (field[x][y] == 0)
                    {
                        continue;
                    }

                    counter++;

                    var queue = new Queue<Tuple<int, int>>();
                    queue.Enqueue(Tuple.Create(x, y));
                    while (queue.Any())
                    {
                        var coordinate = queue.Dequeue();
                        var x1 = coordinate.Item1;
                        var y1 = coordinate.Item2;
                        for (int dx = -1; dx <= 1; dx++)
                        {
                            for (int dy = -1; dy <= 1; dy++)
                            {
                                if (Math.Abs(dx + dy) != 1)
                                {
                                    continue;
                                }

                                var x2 = x1 + dx;
                                var y2 = y1 + dy;
                                if (0 <= x2 && x2 < h && 0 <= y2 && y2 < w && field[x2][y2] == 1)
                                {
                                    field[x2][y2] = 0;
                                    queue.Enqueue(Tuple.Create(x2, y2));
                                }
                            }
                        }

                    }
                }
            }

            Console.WriteLine(counter);
        }
    }
}