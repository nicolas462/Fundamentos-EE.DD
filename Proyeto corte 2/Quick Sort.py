""" Se ordenarán datos de un arreglo recibidos por consola
con el algoritmo 'Quick Sort'"""
def quickSort(a):
    greater_array = [] #Arreglo donde van los menores que el pívote.
    less_array = [] #Arreglo donde van los mayores que el pívote.
    pivot_array = [] #Pivotes seleccionados.

    if len(a) <= 1:
        #Cuando el arreglo ya está ordenado. Fin de la recursión.
        return a
    else:
        #Tomar el primer elemento como pívote
        pivot = a[0]
        for i in a:
            if i < pivot: #Se agrega a la lista de menores que el pivote
                less_array.append(i)
            elif i > pivot: #Se agrega a la lista de mayores que el pivote
                greater_array.append(i)
            else:
                pivot_array.append(i)
        greater_array = quickSort(greater_array) #Se llama recursión
        less_array = quickSort(less_array) #Se llama recursión

    return less_array + pivot_array + greater_array 

print ("Ingrese números: ")
a = input()
list = a.split(",") #Se dividen los valores por comas y se guardan en una lista.
quickSort(list) #Se llama a la función
print ("Arreglo ordenado :", quickSort(list) )

"""def quickSort (A):
	if len (A) == 1:
		return A
	else:
		greater_subarray =[]
		less_subarray = []
		array = []
		pivot = A[0]
		for i in range (1, len(A)):
			if A[i] < pivot:
				less_subarray.append(A[i])
			else:
				greater_subarray.append(A[i])
				aux = []
				aux.append(quickSort(less_subarray), pivot, quickSort(greater_subarray))
			return aux

lista = [8,9,10,4,1,2]
enteros = []
for i in range (0, len(lista)):
	enteros.append(int (lista[i]))
print (quickSort(enteros))"""
