numbers1 = list(input("Enter the numbers sepated by space : ").split(" "))
numbers2 = list(input("Enter the numbers sepated by space : ").split(" "))
numbers3 = []

for i in numbers1:
    if(int(i)%2 > 0):
        numbers3.append(i)
    else:
        continue
for j in numbers2:
    if(int(j)%2 == 0):
        numbers3.append(j)
    else:
        continue    
print(numbers3)    
