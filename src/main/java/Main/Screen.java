package Main;

import Entities.Mobs.Mob;
import Entities.Mobs.Player;
import Graphics.Sprite;
import Graphics.World;
import Graphics.Tiles.Tile;
import Inventory.Inventory;

public class Screen {
int pixels[];
public int screen_width,screen_height;

public int xOffset=0,yOffset=0;
	Screen(int pixels[], int width, int height){
		this.screen_width=width;
		this.screen_height=height;
		this.pixels=pixels;
	}
	public void clear() {
		for(int i=0;i<pixels.length;i++) {
			pixels[i]=0;
		}
	}

	public void render_map(World world, int xScroll,int yScroll) {
		xOffset=xScroll;
		yOffset=yScroll;
		int tile_index;
		int tile_map[]=world.background;
		//corner tiles to be rendered
		int x0=(xOffset>>4);
		int x1=((xOffset+screen_width)>>4)+1;		
		int y0=yOffset>>4;
		int y1=((yOffset+screen_height)>>4)+1;		
		int col; 
		
		for(int y=y0;y<y1;y++) {
			for( int x=x0;x<x1;x++) {
				if(x<0||y<0 || x >= world.MAP_WIDTH || y >= world.MAP_HEIGHT){
				render_sprite((x*16),(y*16),Sprite.water);
				}else {
				tile_index=(x+(y*world.MAP_WIDTH));
				render_sprite((x*16),(y*16),Sprite.getSprite(tile_map[tile_index]));
				}
			}
		}
		tile_map=world.foreground;
		for(int y=y0;y<y1;y++) {
			for( int x=x0;x<x1;x++) {
				if(x<0||y<0 || x >= world.MAP_WIDTH || y >= world.MAP_HEIGHT) {
					continue;
				}else {
					tile_index=(x+(y*world.MAP_WIDTH));	
					col=tile_map[tile_index];					 
					render_sprite((x*16),(y*16),Sprite.getSprite(col));	
				}
			}
		}
	}
	public void render_sprite(int rounded_xOffset,int rounded_yOffset, Sprite sprite) {
		 int yy,xx;
		 int col;
		 int slight_shift_x,slight_shift_y;
		 slight_shift_x=rounded_xOffset-xOffset;
		 slight_shift_y=rounded_yOffset-yOffset;
		 
		 for(int y=0;y<sprite.height;y++) {
			 yy=y+slight_shift_y;
			 for(int x=0;x<sprite.width;x++) {
				 xx=x+slight_shift_x;
				 col= sprite.pixels[x + (y* sprite.width)];
				 if(xx<0||xx>=screen_width||yy<0||yy>=screen_height)
					 continue;
				 if(col ==Tile.transparent_col)
					 continue;			 
				 pixels[xx+(yy*screen_width)]=col;
				 
			 }
		 }
		 
		
	}
	public void render_inventory() {
		Sprite sprite= Inventory.inventory.sprite;
		for(int y=0;y<sprite.height;y++) {
			for(int x=0;x<sprite.width;x++) {
				pixels[x +(y* screen_width)]= sprite.pixels[x +(y* sprite.width)];
			}
		}
		
	} 
	public void render_player(Player player) {
		int xp, yp;
		int col;
		int size=player.size;
		int player_pixels[]=player.sprite.pixels;
		for(int y=0;y<size;y++ ) {
			for(int x=0;x<size;x++) {
				xp=((screen_width>>1)-(size>>1));
				yp=((screen_height>>1)-(size>>1));
				col=player_pixels[x+(y*size)];
				if(col==0xFFFF00FA)
					continue;
				pixels[(xp+x)+(yp+y)*screen_width]=col;
			}
		}
	}
	public void render_mob(Mob mob) {
		int relative_xp=mob.getX()-xOffset;
		int relative_yp=mob.getY()-yOffset;
		int yy,xx;
		int col;
		int size=mob.size;
		for(int y=0;y<size;y++) {
			yy=relative_yp+y;
			for(int x=0;x<size;x++) {
				xx=relative_xp+x;
				col=mob.sprite.pixels[x+(y*mob.size)];
				if(xx<0||xx>=screen_width||yy<0||yy>=screen_height)
					continue;
				if(col==0xFFFF00FA)
					continue;
				pixels[xx +(yy*screen_width)]=col;
				  
				
			}
		}
		
	}

}
