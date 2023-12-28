import { Component, Input, AfterViewInit } from '@angular/core';
import * as L from 'leaflet';
import { City } from '../models/city';

@Component({
	selector: 'app-osm-map',
	templateUrl: './osm-map.component.html',
	styleUrls: ['./osm-map.component.scss']
})
export class OsmMapComponent implements AfterViewInit {
	@Input() centerCoordinates: L.LatLngTuple = [43.146785, 13.064328];
	@Input() zoomLevel: number = 18;
	@Input() cities: any[] = [];
	
	title = 'OSM Map';

	private initMap() : void {
		const map = L.map('map', {
			center: this.centerCoordinates,
			zoom: this.zoomLevel
		});
		
		const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
			maxZoom: 18,
			minZoom: 3,
			attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
		});

		tiles.addTo(map);
		
		this.cities.forEach(city => {
			var marker = L.marker(city.coordinates, {
				title: city.name,
				draggable: false,
			});
			marker.addTo(map);
			marker.bindPopup(this.popup(city));
		});
	}
	
	ngAfterViewInit(): void {
		this.initMap();
	}

	private popup(city: City) : string {
		return `<a [routerLink]="['city', ${city.id}]">Esplora</a>`;
	}
}
