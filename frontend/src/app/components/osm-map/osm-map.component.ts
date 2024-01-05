import { Component, Input, AfterViewInit } from '@angular/core';
import * as L from 'leaflet';
import { Router } from '@angular/router';

@Component({
	selector: 'app-osm-map',
	templateUrl: './osm-map.component.html',
	styleUrls: ['./osm-map.component.scss']
})
export class OsmMapComponent implements AfterViewInit {
	@Input() centerCoordinates: L.LatLngTuple = [43.146785, 13.064328];
	@Input() zoomLevel: number = 18;
	@Input() items: any[] = [];
	@Input() isForCity: boolean = true;
	@Input() cityId?: number = undefined;

	title = 'OSM Map';

	constructor(private router: Router) {}

	ngAfterViewInit(): void {
		this.initMap();
	}

	private initMap() : void {
		const map = L.map('map', {
			center: this.centerCoordinates,
			zoom: this.zoomLevel
		});

		const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
			maxZoom: 20,
			minZoom: 5,
			attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
		});

		tiles.addTo(map);

		this.items.forEach(item => {
			var marker = L.marker([item.longitude, item.latitude], {
				title: item.name,
				draggable: false,
			});
			marker.bindPopup(`<h3>${item.name}</h3>`);
			marker.on('click', () => {
				if(this.isForCity) {
					this.router.navigate(['city', item.id])
				} else {
					this.router.navigate(['city', this.cityId!, 'points', item.id])
				}
			});
			marker.addTo(map);
		});
	}

}
