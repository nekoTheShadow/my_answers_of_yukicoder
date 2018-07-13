using System;
using System.Collections.Generic;
using System.Linq;

namespace _714
{
    class Program
    {
        static void Main(string[] args)
        {
            var foods = new Dictionary<int, List<string>>();
            var answers = new List<int>();

            var N = int.Parse(Console.ReadLine());
            for (int i = 0; i < N; i++)
            {
                var line = Console.ReadLine().Split(' ').ToList();
                var type = line[0];
                
                if (type == "0")
                {
                    var n = int.Parse(line[1]);
                    var m = int.Parse(line[2]);
                    foods[n] = new List<string>();
                    for (int j = 0; j < m; j++)
                    {
                        foods[n].Add(line[j + 3]);
                    }
                }

                if (type == "1")
                {
                    var answer = -1;
                    var b = line[1];
                    for (int x = 1; x <= 20; x++)
                    {
                        if (!foods.ContainsKey(x))
                        {
                            continue;
                        }

                        int y = foods[x].FindIndex(fav => fav == b);
                        if (y == -1)
                        {
                            continue;
                        }

                        answer = x;
                        foods[x].RemoveAt(y);
                        break;
                    }

                    answers.Add(answer);
                }

                if (type == "2")
                {
                    int c = int.Parse(line[1]);
                    foods.Remove(c);
                }
            }

            foreach (var answer in answers)
            {
                Console.WriteLine(answer);
            }
        }
    }
}
