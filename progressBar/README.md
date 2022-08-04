# ProgressBar

 - Barra de progresso circular ou horizontal. 
 - O objetivo da barra é fazer com que o usuário espere um certo tempo até que um processo seja concluido.

## Sobre Threads

Main thread, ou Thread
principal, ou Thread de
interface, ou ainda Thread
UI - são sinônimos.
Uma thread é uma forma de
um processo dividir a si
mesmo em duas ou mais
tarefas que podem ser
executadas de forma
concorrente.

### Thread Principal
<b>Por quê?</b>

- Porque no Android é somente na Thread principal que componentes visuais podem ser atualizados.
Processamentos que podem travar a tela, mesmo que por poucos segundos,
devem ocorrer fora da Thread principal, caso contrário, exceção novamente.

<b>runOnUiThread</b>

- runOnUiThread deve ser entendido como um atalho, seguro e recomendado
para o acesso à thread principal de um aplicativo Android.
Muitas das APIs de comunicação remota no Android já têm o próprio método de
acesso a thread principal, ou seja, para essas APIs não será preciso o uso da
runOnUiThread ou de qualquer outra API que já não seja a da própria biblioteca
de comunicação remota em uso.