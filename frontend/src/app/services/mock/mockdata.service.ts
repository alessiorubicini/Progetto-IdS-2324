import { Injectable } from '@angular/core';
import { City } from 'src/app/models/city';

@Injectable({
	providedIn: 'root'
})
export class MockdataService {
	
	constructor() { }
	
	public static getCityMocks() : City[] {
		return [
			{ id: 1, cadastralCode: "ABC123", name: "Porto San Giorgio", region: "Marche", province: "FM", istatCode: "12345", longitude: 43.180144, latitude: 13.793122, points: [], contests: []},
			{ id: 2, cadastralCode: "DEF456", name: "Camerino", region: "Marche", province: "MC", istatCode: "67890", longitude: 43.135702, latitude: 13.068382, points: [], contests: [] },
			{ id: 3, cadastralCode: "GHI789", name: "Senigallia", region: "Marche", province: "AN", istatCode: "98765", longitude: 43.719696, latitude: 13.215435, points: [], contests: [] }
		]
	}
	
}
