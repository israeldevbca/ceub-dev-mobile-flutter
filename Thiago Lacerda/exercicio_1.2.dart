// Escreva uma função que receba um ano (int) e retorne o século daquele ano.

void main() {

  int ano = 1990;
  int seculo = calcularSeculo(ano);
  print("O ano $ano, é do século $seculo! :)");
}

int calcularSeculo(int ano) {
  int seculo = (ano +99) ~/ 100;
  return seculo;
}