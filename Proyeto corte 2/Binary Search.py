""" Buscar un valor en un arreglo con el algoritmo de 'Binary Search'"""

#Algoritmo sin recursión
def binarySearch(a, x):
    lowerBound = 0 #Límite inferior
    upperBound = len (a) -1 #Límite superior
    index = -1
    #Si el límite superior es menor que el límite inferior, no hay soluciín
    #factible, pueto que el arrglo tiene que estar ordenado.
    while lowerBound <= upperBound:
    	middlePoint =  int ((lowerBound + upperBound) /2)
    	if x == a[middlePoint]:
    		#X has sido encontrado
    		index = middlePoint
    		break
    	else:
    		if x < a[middlePoint]:
    			upperBound = middlePoint -1
    		else:
    			lowerBound = middlePoint + 1
    if lowerBound == upperBound and a[lowerBound] == x:
    	index = lowerBound
    return index

#a = Arreglo ordenado // x= valor a encontrar // lB = índice de inicio (0) // uB = índice final (tamaño -1)
def binarySearch_recur (a, x, lB, uB):
	middlePoint = int ((lB + uB)/2)
	#Si el límite superior es igual que el límite inferior, solo hay una solución factible.
	if lB == uB:
		if x == a[middlePoint]:
			#Elemento x ha sido encontrado. 
			return middlePoint
		else:
			return -1
	else:
		if x == a[middlePoint]:
			return middlePoint
		elif x < a[middlePoint]:
			return binarySearch_recur (a, x, lB, middlePoint)
		else:
			return binarySearch_recur (a, x, middlePoint+1, uB)


print ("Ingrese números: ")
a = input()
print ("Ingrese número a buscar: ")
x = input()
list = a.split(",") #Se dividen los valores por comas y se guardan en una lista.
indice = binarySearch(list, x) #Se guarda el valor de la función sin recursión.
print ("Resultado algoritmo sin recursión: ")
if (indice >= 0):
	print ("El número está en el índice: ", indice, "\n")
else:
	print ("El número no se encontró.\n")
indice2 = binarySearch_recur(list, x, 0, len (list) -1) #Se guarda valor de la función recursiva.
print ("Resultado algoritmo recursivo: ")
if (indice2 >= 0):
	print ("El número está en el índice: ", indice)
else:
	print ("El número no se encontró.")
