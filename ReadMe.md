---


---

<h1 id="introduzione">Introduzione</h1>
<p>Il seguente progetto è stato svolto per il corso di Programmazione ad Oggetti offerto dall’Università Politecnica delle Marche.</p>
<p>L’applicazione, basata sul linguaggio di programmazione Java, sfrutta il framework Spring e i vantaggi di un linguaggio OOP (incapsulamento, ereditarietà e polimorfismo).</p>
<h1 id="utilizzo-del-software">Utilizzo del software</h1>
<h2 id="cosa-può-fare">Cosa può fare</h2>
<p>All’avvio, l’applicazione apre una connessione con il web-server in locale sula porta 8080. Viene scaricato in automatico il dataset ed effettua il parsing del file CSV contenuto nell’<a href="http://data.europa.eu/euodp/data/api/3/action/package_show?id=erasmus-mobility-statistics-2011-12">URL</a> assegnatoci.</p>
<p>Per testare il software è possibile utilizzare Postman, ambiente attraverso il quale è possibile richiedere dati, metadati, statistiche sui dati e si possono applicare filtri a dati e statistiche.</p>
<h3 id="dati">Dati</h3>
<p>Per richiedere i dati contenuti nel file CSV bisogna impostare il metodo “GET” e definire la rotta</p>
<pre><code>localhost:8080/data
</code></pre>
<h3 id="metadati">Metadati</h3>
<p>Per richiedere i metadati bisogna impostare il metodo <strong>GET</strong> e definire la rotta</p>
<pre><code>localhost:8080/metadata
</code></pre>
<h3 id="statistiche">Statistiche</h3>
<p>Per ottenere le statistiche di ogni attributo del dataset bisogna impostare il metodo <strong>GET</strong> e definire la rotta</p>
<pre><code>localhost:8080/stats
</code></pre>
<p>oppure ad esempio per il campo Gender, bisogna specificare nella rotta il campo <em>field</em> nel seguente modo:</p>
<pre><code>localhost:8080/stats?field=Gender
</code></pre>
<p>che restituisce:</p>
<pre><code>[
    {
	    "field": "Gender",
	    "elementi unici": {
		    "F": 273,
		    "M" : 227
		},
	    "count": 500
	    }
]
</code></pre>
<h2 id="come-applicare-un-filtro">Come applicare un filtro</h2>
<p>Per applicare un filtro ai dati bisogna scegliere il metodo <strong>POST</strong> . Sul body impostare la stringa <em>raw</em> con il formato <em>JSON(application/json)</em>.</p>
<p><em><strong>Esempio(Age):</strong></em></p>
<pre><code>localhost:8080/data
</code></pre>
<p>e aggiungere nel body la stringa:</p>
<pre><code>{"fieldName": "Age", "op":"&amp;gt", "rif":23}
</code></pre>
<p>Se invece si vuole lavorare con le statistiche di tutti i dati filtrati, impostare il metodo <strong>POST</strong> e assegnare la rotta:</p>
<pre><code>localhost:8080/stats
</code></pre>
<p><em><strong>Esempio(Country)</strong></em></p>
<pre><code>{"fieldName":"Country", "op":"&amp;in", "rif":["DE","ES","CZ"]}
</code></pre>
<p>Vengono restituite le statistiche di tutti i campi che hanno al loro interno gli elementi DE, ES, CZ .</p>
<p>Se si vogliono ottenere le statistiche di un solo campo della lista dei dati filtrati, bisogna specificare nella rotta, attraverso la variabile field, il nome dell’attributo desiderato. Ad esempio:</p>
<pre><code>localhost:8080/stats?field=Age
</code></pre>
<p>che restituisce le statistiche del solo campo Age preso dalla lista dei dati filtrati secondo quanto specificato nel body.</p>
<p><strong>fieldName</strong> rappresenta il nome del campo su cui applicare il filtro</p>
<p><strong>op</strong> indica l’operatore ovvero il tipo di filtro richiesto. Si possono applicare i seguenti operatori:</p>
<ul>
<li>
<p>&amp;eq : uguaglianza di due valori</p>
</li>
<li>
<p>&amp;not : non uguaglianza tra due valori</p>
</li>
<li>
<p>&amp;gt : (greater than) elementi maggiori del valore passato</p>
</li>
<li>
<p>&amp;gte : elementi maggiori e uguali al valore passato</p>
</li>
<li>
<p>&amp;lt : (less than) elementi minori al valore passato</p>
</li>
<li>
<p>&amp;lte : elementi minori e uguali al valore passato</p>
</li>
<li>
<p>&amp;in : elemento contenuto nei dati</p>
</li>
<li>
<p>&amp;nin : elemento non contenuto nei dati</p>
</li>
<li>
<p>&amp;bt : (between) elemento compreso tra i valori passati al riferimento</p>
</li>
</ul>
<p><strong>Rif</strong> simboleggia il valore di riferimento.</p>
<p><strong>Altri esempi:</strong><br>
1- se il riferimento è una stringa</p>
<pre><code>{"fieldName":"Country", "op":"&amp;eq", "rif":"DE"}
</code></pre>
<p>2-se il riferimento è una lista di stringhe</p>
<pre><code>{"fieldName":"Nationality", "op":"&amp;in", "rif":["DE","FR","ES"]}
</code></pre>
<p>3-se il riferimento è una lista di numeri</p>
<pre><code>{"fieldName":"LengthStudyPeriod", "op":"&amp;bt", "rif":[2.5,10.25]}
</code></pre>
<p><em><strong>Di seguito viene elencata la lista degli attributi:</strong></em><br>
HomeInstitution<br>
Country<br>
Nationality<br>
LevelStudy<br>
HostInstitution<br>
CountryCodeOfHostInstitution<br>
PlacementEnterprise<br>
CountryOfPlacement<br>
StudyStartDate<br>
PlacementStartDate<br>
ConsortiumAgreementNumber<br>
LanguageTaught<br>
LingPreparation<br>
Gender<br>
MobilityType<br>
EnterpriseSize<br>
TypePlacementSector<br>
ShortDuration<br>
TaughtHostLang<br>
PreviousParticipation<br>
QualificationAtHost<br>
Age<br>
SubjectArea<br>
YearsPrior<br>
EctsCreditsStudy<br>
EctsCreditsPlacement<br>
TotalEcts<br>
LengthStudyPeriod<br>
LengthPlacement<br>
PlacementGrant<br>
StudyGrant<br>
SnSupplement</p>
<h1 id="struttura-del-codice">Struttura del codice</h1>
<h2 id="packaging">Packaging</h2>
<p>Le classi sono inserite in quattro package principali basati sulla logica MVC (Model View Controller):</p>
<p><em>Controller</em> racchiude tutti i metodi necessari per far fronte alle richieste GET e POST.</p>
<p><em>Model</em> contiene la classe principale su cui si basa l’intero programma.</p>
<p><em>Service</em> è utile nell’implementazione di metodi che gestiscono l’accesso a dati, metadati, statistiche e filtri.</p>
<p><em>Utilities</em> include la classe che permette di fare il download e il parsing del file CSV.</p>
<h2 id="diagrammi">Diagrammi</h2>
<h3 id="casi-duso">Casi d’uso</h3>
<p><img src="https://github.com/ErmelindaBegotaraj/Progetto/blob/master/Progetto/diagrammi/diagrcasiduso.jpg" alt=""></p>
<h3 id="classi">Classi</h3>
<p><img src="https://github.com/ErmelindaBegotaraj/Progetto/blob/master/Progetto/diagrammi/newdiagram.jpg" alt=""></p>
<h3 id="sequenze">Sequenze</h3>
<h4 id="get-data">GET data</h4>
<p><img src="https://github.com/ErmelindaBegotaraj/Progetto/blob/master/Progetto/diagrammi/sequenzeData.jpg" alt=""></p>
<h4 id="get-metadata">GET metadata</h4>
<p><img src="https://github.com/ErmelindaBegotaraj/Progetto/blob/master/Progetto/diagrammi/sequenzeMetadata.jpg" alt=""></p>
<h4 id="get-stats">GET stats</h4>
<p><img src="https://github.com/ErmelindaBegotaraj/Progetto/blob/master/Progetto/diagrammi/sequenzestats.jpg" alt=""></p>
<h4 id="post-data">POST data</h4>
<p><img src="https://github.com/ErmelindaBegotaraj/Progetto/blob/master/Progetto/diagrammi/seqpostdata.jpg" alt=""></p>
<h4 id="post-stats">POST stats</h4>
<p><img src="https://github.com/ErmelindaBegotaraj/Progetto/blob/master/Progetto/diagrammi/postStats.jpg" alt=""></p>

