# Progetto IdS + Modulo Web e Mobile 23/24
Progetto realizzato dagli studenti Alessio Rubicini, Maria Vittoria Forlani e Simone Morello per gli esami di Ingegneria del Software (prof. Polini e prof. Morichetta) e di applicazioni web, mobile e cloud (modulo web e mobile, prof. Bonura) dell'anno accademico 2023/24 presso l'Università di Camerino.

## Descrizione del progetto

Il progetto prevede lo sviluppo di una piattaforma di valorizzazione e digitalizzazione di un territorio comunale attraverso il caricamento di informazioni culturali, turistiche, sportive e di qualsiasi altra natura che possano essere di interesse per chi vive e frequenta un territorio. 

Il caricamento sulla piattaforma di qualsiasi contenuto è da riferirsi a un punto geolocalizzato presente sul comune e i contenuti si riferiranno dunque all’emergenza presente in quel dato punto. Allo stesso tempo si potrebbero aggiungere contenuti di natura più generale che si riferiscano ad esempio all’intero comune. In tal caso tali contenuti saranno associati al punto che identifica il comune stesso. Si possono dunque immaginare almeno due tipologie di punti: il primo di natura fisica che corrisponde ad un concetto fisico spaziale, e dunque alle emergenze che fisicamente si trovano su quel punto. Il secondo si riferisce ad un concetto di natura più logica (concetto politico/geografico/amministrativo). Ogni singolo comune potrà gestire i punti che ricadono sotto il proprio territorio e non sarà possibile aggiungere informazioni su altri comuni. 

L’obiettivo del progetto è dunque quello di creare una piattaforma che permetta di gestire contenuti di qualsiasi natura in relazione ad un dato territorio. Si immagina una piattaforma collaborativa in cui la cittadinanza stessa possa contribuire ad arricchire la piattaforma con contenuti testuali e/o multimediali. In tal caso chiaramente i contenuti saranno pubblicati sulla piattaforma soltanto dopo la verifica di conformità del contenuto in relazione ai fini del progetto.

È possibile creare itinerari o esperienze che rappresentano insiemi ordinati, o non, di punti di interesse. Tali itinerari saranno definiti secondo le stesse strategie dei punti di interesse, ovvero caricati da responsabili o in maniera collaborativa e successivamente confermati.


### Ingegneria del software
Il progetto deve essere sviluppato in Java e successivamente portato su Spring Boot. Lo strato di presentazione può essere sviluppato con strumenti a scelta dello studente ed eventualmente può limitarsi alla linea di comando e/o API REST.  Si raccomanda di includere nel codice almeno un design pattern che non sia il Singleton.

### Web e mobile
Per quanto riguarda il modulo di applicazioni web e mobile è stato scelto di realizzare un frontend web(fruibile sia da desktop sia da mobile) utilizzando il framework AngularJS.