
dynamic secular({year = 2024, roman = false}) {
  var sec = (year % 100 == 0) ? (year/100) : ((year/100).toInt()+1); // verifica se é um seculo completo ou corrente, seculos completos são 1800, 1900, 2000...
  if (!roman) return sec;

  return toRoman(sec);
  
  
}

String toRoman(int sec) {
  var romans = ['I', 'IV', 'V', 'IX', 'X', 'XL', 'L', 'XC', 'C']; // combinações de numeros Romanos
  var values = [1, 4, 5, 9, 10, 40, 50, 90, 100]; // valores de cada combinação
  var result = ''; //esta String será complementada com os valores romanos currentes

  for (var i = values.length - 1; i >= 0; i--) /*percorre a lista de tras para frente deduzindo os valores a serem convertidos do total */{
    while (sec >= values[i]) {
      result += romans[i]; // adiciona a combinação equivalente ao resultado
      sec -= values[i]; // deduz o valor convertido do valor total para ter ciencia de quanto falta
    }
  }

  return result;
}




void main() {
  print(secular(year: 1418, roman: true)); //retorna XV referente ao seculo 15
  print(secular(year: 2000)); //deve retornar 20 para testar o antigo bug de seculos
  print(secular(year: 2001)); //deve retornar 21 para testar o antigo bug de seculos
}
