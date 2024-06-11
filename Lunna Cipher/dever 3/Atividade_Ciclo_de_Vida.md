Atividade 

 - Faça um override dos métodos que cuidam do ciclo de vida. 
  - Em cada callback adicione o um log ``Log.i("TELA", "SUA MENSAGEM")``
  - Execute o aplicativo em um emulador ou dispositivo físico. 
  - Mostre qual ordem de execução de cada callback do ciclo de vida do Android. 
  - Gire o celular para horizontal? O que acontece?
  - Aperte o botão de menu, para minimar o app, o que acontece?

resolução
=================================================

modificação de codigo
------------------------------

- onCreate
```kotlin
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.i("TELA", "função onCreate executada");
}
```

- onStart
```kotlin
@Override
protected void onStart() {
    super.onStart();
    Log.i("TELA", "função onStart executada");
}
```

- onResume
```kotlin
@Override
protected void onResume() {
    super.onResume();
    Log.i("TELA", "função onResume executada");
}
```

- onPause
```kotlin
@Override
protected void onPause() {
    super.onPause();
    Log.i("TELA", "função onPause executada");
}
```

- onStop
```kotlin
@Override
protected void onStop() {
    super.onStop();
    Log.i("TELA", "função onStop executada");
}
```

- onDestroy
```kotlin
@Override
protected void onDestroy() {
    super.onDestroy();
    Log.i("TELA", "função onDestroy executada");
}
```

resultado dos testes de saida
-----------
- ao entrar no aplicativo
    ```shell
    função onCreate executada
    função onStart executada
    função onResume executada
    ```

- ao minimizar o aplicativo
    ```shell
    função onPause executada
    função onStop executada
    ```
- ao fechar o aplicativo
    ```shell
    função onPause executada
    função onStop executada
    função onDestroy executada
    ```
- desligar a tela
    ```shell
    função onPause executada
    ```
- ligar a tela
    ```shell
    função onResume executada
    ```
- ao trocar de aplicativo
    ```shell
    função onPause executada
    função onStop executada
    ```
- apertar o botão home
    ```shell
    função onPause executada
    função onStop executada
    ```
- retornar ao aplicativo
    ```shell
    função onRestart executada
    função onStart executada
    função onResume executada
    ```
- rotacionar a tela do celular
    ```shell
    função onPause executada
    função onStop executada
    função onDestroy executada
    função onCreate executada
    função onStart executada
    função onResume executada
    ```