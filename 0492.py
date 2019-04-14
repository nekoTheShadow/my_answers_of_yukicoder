import datetime

t = datetime.date(2015, 1, 1)
oneday = datetime.timedelta(1)
count = 0
while t.year == 2015:
    x = t.month
    y = t.day
    if x == y // 10 + y % 10:
        count += 1
    t += oneday

print(count)