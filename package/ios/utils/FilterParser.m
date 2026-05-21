#import "FilterParser.h"
#import <MapVina/MapVina.h>

@implementation FilterParser

+ (NSPredicate *)parse:(NSArray *)filterList {
  if (filterList == nil || filterList.count < 1) {
    return nil;
  }
  return [NSPredicate predicateWithMLNJSONObject:filterList];
}

@end
