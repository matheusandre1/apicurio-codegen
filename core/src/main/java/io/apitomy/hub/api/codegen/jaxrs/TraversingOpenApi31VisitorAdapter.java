package io.apitomy.hub.api.codegen.jaxrs;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import io.apitomy.datamodels.models.Node;
import io.apitomy.datamodels.models.Operation;
import io.apitomy.datamodels.models.openapi.OpenApiPathItem;
import io.apitomy.datamodels.models.openapi.v3x.v31.visitors.OpenApi31VisitorAdapter;
import io.apitomy.datamodels.models.visitors.TraversalContext;
import io.apitomy.datamodels.models.visitors.TraversingVisitor;
import io.apitomy.datamodels.util.NodeUtil;

public abstract class TraversingOpenApi31VisitorAdapter extends OpenApi31VisitorAdapter implements TraversingVisitor {

    protected static final JsonNodeFactory factory = JsonNodeFactory.instance;

    protected TraversalContext traversalContext;

    /**
     * @see io.apitomy.datamodels.models.visitors.TraversingVisitor#setTraversalContext(io.apitomy.datamodels.models.visitors.TraversalContext)
     */
    @Override
    public void setTraversalContext(TraversalContext context) {
        this.traversalContext = context;
    }

    protected String getPathTemplate(OpenApiPathItem pathItem) {
        if (NodeUtil.isDefinition(pathItem)) {
            return null;
        } else {
            return getMappedNodeName(pathItem);
        }
    }

    protected String getOperationMethod(Operation operation) {
        return (String) this.traversalContext.getMostRecentStep().getValue();
    }

    protected String getMappedNodeName(Node node) {
        return (String) this.traversalContext.getMostRecentStep().getValue();
    }

}
