import type { FilterSpecification } from "@mapvina/mapvina-gl-style-spec";

export function getNativeFilter(
  filter: FilterSpecification | undefined,
): unknown[] {
  if (Array.isArray(filter)) {
    return filter;
  }

  if (typeof filter === "boolean") {
    return ["literal", filter] satisfies FilterSpecification;
  }

  return [];
}
