\\atividade pendente
  double somaNumeros(double n1, double n2) {
    return n1 + n2;
  }
  
  print(somaNumeros(5,10));
  
  int getSeculoAno(int ano){
    return (ano%100) == 0 ? (ano/100).toInt() : (ano/100).toInt() +1;
  }
  
  
  int getSeculoAnoCeil(int ano) {
    return (ano/100).ceil();
  }