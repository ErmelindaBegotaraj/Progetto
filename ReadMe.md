---


---

<h1 id="introduzione">Introduzione</h1>
<p>Il seguente progetto è stato svolto per il corso di Programmazione ad Oggetti offerto dall’Università Politecnica delle Marche.</p>
<p>L’applicazione, basata sul linguaggio di programmazione Java, sfrutta il framework Spring e i vantaggi di un linguaggio OOP (incapsulamento, ereditarietà e polimorfismo).</p>
<h1 id="utilizzo-del-software">Utilizzo del software</h1>
<h2 id="cosa-può-fare">Cosa può fare</h2>
<p>All’avvio, l’applicazione apre una connessione con il web-server in locale sula porta 8080. Viene scaricato in automatico il dataset ed effettua il parsing del file CSV contenuto nell’<a href="http://data.europa.eu/euodp/data/api/3/action/package_show?id=erasmus-mobility-statistics-2011-12">URL</a> assegnatoci.</p>
<p>Per testare il software è possibile utilizzare Postman, ambiente attraverso il quale è possibile richiedere dati, metadati, statistiche sui dati e si possono applicare filtri a dati e statistiche.</p>
<h2 id="come-applicare-un-filtro">Come applicare un filtro</h2>
<h2 id="esempi">Esempi</h2>
<h1 id="struttura-del-codice">Struttura del codice</h1>
<h2 id="packaging">Packaging</h2>
<p>Le classi sono inserite in quattro package principali basati sulla logica MVC (Model View Controller):</p>
<p><em>Controller</em> racchiude tutti i metodi necessari per far fronte alle richieste GET e POST.</p>
<p><em>Model</em> contiene la classe principale su cui si basa l’intero programma.</p>
<p><em>Service</em> è utile nell’implementazione di metodi che gestiscono l’accesso a dati, metadati, statistiche e filtri.</p>
<p><em>Utilities</em> include la classe che permette di fare il download e il parsing del file CSV.</p>
<h2 id="diagrammi">Diagrammi</h2>
<h3 id="diagramma-dei-casi-duso">Diagramma dei casi d’uso</h3>
<p><img src="https://github.com/ErmelindaBegotaraj/FirstProject/blob/master/casi%20d%27uso.jpg" alt=""></p>

