
dynamic secular({year = 2024, roman = false}) {
  var sec = (year % 100 == 0) ? (year/100) : ((year/100).toInt()+1);
  if (!roman) return sec;

  return toRoman(sec);
  
  
}

String toRoman(int sec) {
  var romans = ['I', 'IV', 'V', 'IX', 'X', 'XL', 'L', 'XC', 'C'];
  var values = [1, 4, 5, 9, 10, 40, 50, 90, 100];
  var result = '';

  for (var i = values.length - 1; i >= 0; i--) {
    while (sec >= values[i]) {
      result += romans[i];
      sec -= values[i];
    }
  }

  return result;
}




void main() {
  print(secular(year: 1418, roman: true)); //retorna XV referente ao seculo 15
}
