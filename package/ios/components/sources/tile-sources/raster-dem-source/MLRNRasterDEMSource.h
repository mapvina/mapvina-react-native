#import "MLRNTileSource.h"

#import <MapVina/MapVina.h>

@interface MLRNRasterDEMSource : MLRNTileSource

@property (nonatomic, strong) NSNumber *tileSize;
@property (nonatomic, copy) NSString *encoding;

@end
